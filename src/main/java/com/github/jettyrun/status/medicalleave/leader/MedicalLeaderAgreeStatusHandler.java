package com.github.jettyrun.status.medicalleave.leader;

import com.github.jettyrun.LeavePermit;
import com.github.jettyrun.status.handle.StatusHandler;

/**
 * Created by jetty on 18/1/9.
 */
public class MedicalLeaderAgreeStatusHandler extends StatusHandler{

    protected void doHandler(LeavePermit leavePermit){
        leavePermit.setEvent(null);
        System.out.println(String.format("user:%s--领导同意休病假--leavePermit status:%s-%s",leavePermit.getUser(),leavePermit.getStatus().getStatus(),leavePermit.getStatus().getMemo()));
    }

}
