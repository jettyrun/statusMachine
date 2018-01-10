package com.github.jettyrun.status.medicalleave.leader;

import com.github.jettyrun.LeavePermit;
import com.github.jettyrun.engine.StatusMachineEngine;
import com.github.jettyrun.status.handle.StatusHandler;
import com.github.jettyrun.status.machine.factory.StatusMachineFactory;

/**
 * Created by jetty on 18/1/9.
 */
public class MedicalLeaderPermitingStatusHandler extends StatusHandler{

    protected void doHandler(LeavePermit leavePermit){
        System.out.println(String.format("user:%s--领导审批病假中--leavePermit status:%s-%s",leavePermit.getUser(),leavePermit.getStatus().getStatus(),leavePermit.getStatus().getMemo()));
    }
    @Override
    protected void after(LeavePermit leavePermit){

        if(leavePermit.getEvent()==null){
            //还未审批，状态机结束，等待审批意见
            System.out.println(String.format("user:%s--等待领导病假审批--leavePermit status:%s-%s",leavePermit.getUser(),leavePermit.getStatus().getStatus(),leavePermit.getStatus().getMemo()));
            return;
        }
        goNextStatusHandler(leavePermit);
    }
}
