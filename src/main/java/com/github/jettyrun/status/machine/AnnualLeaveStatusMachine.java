package com.github.jettyrun.status.machine;

import com.github.jettyrun.status.Status;
import com.github.jettyrun.status.event.Event;

/**
 * Created by jetty on 18/1/9.
 */
public class AnnualLeaveStatusMachine implements StatusMachine{


    public Status getNextStatus(Status status,Event event){
        switch (status){

            case PERMIT_SUBMIT:
                //提交假单状态无需审批跳转领导审批中状态
                return Status.LEADER_PERMITING;

            case LEADER_PERMITING:
                //领导审批需要审批意见 审批意见不用返回不同的状态
                return getLeaderPermitStatus(event);
            case LEADER_PERMIT_AGREE:
                //领导同意请假，则跳转ceo审批
                return Status.CEO_PERMITING;
            case LEADER_PERMIT_DISAGREE:
                //领导不同意该假单，则请假失败
                return Status.PERMIT_FAIL;
            case LEADER_PERMIT_MODIFY:
                return getLeaderPermitStatus(event);

            case CEO_PERMITING:
                //ceo审批需要审批意见
                return getCEOPermitStatus(event);
            case CEO_PERMIT_AGREE:
                // ceo审批同意 跳转审批通过 请假完成
                return Status.PERMIT_SUCCESS;

            case CEO_PERMIT_DISAGREE:
                //ceo不同意审批 则跳转审批失败
                return Status.PERMIT_FAIL;
            case CEO_PERMIT_MODIFY:
                return  getCEOPermitStatus(event);

            default:
                throw new RuntimeException("没有该流程");
        }
    }



    private Status getLeaderPermitStatus(Event event){
        switch (event){
            case AGREE:
                //领导审批通过 返回同意该假单
                return Status.LEADER_PERMIT_AGREE;
            case DISSAGREE:
                //领导不同意 则返回领导拒绝改假单状态
                return Status.LEADER_PERMIT_DISAGREE;
            case MODIFY:
                return Status.LEADER_PERMIT_MODIFY;
            default:
                throw new RuntimeException("不支持该Event审批意见");
        }
    }


    private Status getCEOPermitStatus(Event event){
        switch (event){
            case AGREE:
                //ceo审批通过 则返回ceo同意该假单
                return Status.CEO_PERMIT_AGREE;
            case DISSAGREE:
                // ceo审批不通过 则返回ceo不同意该假单状态
                return Status.CEO_PERMIT_DISAGREE;
            case MODIFY:
                return Status.CEO_PERMIT_MODIFY;
            default:
                throw new RuntimeException("不支持该Event审批意见");
        }
    }
}
