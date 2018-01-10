package com.github.jettyrun.status.machine;

import com.github.jettyrun.status.Status;
import com.github.jettyrun.status.event.Event;

/**
 * Created by jetty on 18/1/9.
 */
public class MedicalLeaveStatusMachine implements StatusMachine{

    public Status getNextStatus(Status status,Event event){
        switch (status){
            case PERMIT_SUBMIT:
                    //提交假单状态直接跳转领导审批中状态
                    return Status.LEADER_PERMITING;


            case LEADER_PERMITING:
                    //领导审批中状态需要审批意见再获取下一个状态
                    return getLeaderPermitStatus(event);
            case LEADER_PERMIT_AGREE:
                    //领导同意审批该假单 跳转hr审批中状态
                    return Status.HR_PERMITING;
            case LEADER_PERMIT_DISAGREE:
                    //领导不同意则返回请假失败
                    return Status.PERMIT_FAIL;
            case LEADER_PERMIT_MODIFY:
                    return  getLeaderPermitStatus(event);

            case HR_PERMITING:
                //hr审批根据审批意见跳转下一个状态
                return getHrPermitStatus(event);
            case HR_PERMIT_AGREE:
                //hr审批通过跳转审批完成状态
                return Status.PERMIT_SUCCESS;
            case HR_PERMIT_DISAGREE:
                // hr审批不同意 返回请假失败
                return Status.PERMIT_FAIL;
            case HR_PERMIT_MODIFY:
                return  getHrPermitStatus(event);

            default:
                throw new RuntimeException("没有该流程");
        }
    }


    private Status getLeaderPermitStatus(Event event){
        switch (event){
            case AGREE:
                //领导同意该假单，则返回领导审批通过
                return Status.LEADER_PERMIT_AGREE;
            case DISSAGREE:
                //领导不同意该假单 则返回领导审批不通过
                return Status.LEADER_PERMIT_DISAGREE;
            case MODIFY:
                return Status.LEADER_PERMIT_MODIFY;
            default:
                throw new RuntimeException("不支持该Event审批意见");
        }
    }


    private Status getHrPermitStatus(Event event){
        switch (event){
            case AGREE:
                //hr审批同意该假单，则返回hr同意状态
                return Status.HR_PERMIT_AGREE;
            case DISSAGREE:
                //hr审批不同意该假单，则返回hr不同意状态
                return Status.HR_PERMIT_DISAGREE;
            case MODIFY:
                return Status.HR_PERMIT_MODIFY;
            default:
                throw new RuntimeException("不支持该Event审批意见");
        }
    }

}
