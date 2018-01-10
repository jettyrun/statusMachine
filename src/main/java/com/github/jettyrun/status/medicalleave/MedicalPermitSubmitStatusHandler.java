package com.github.jettyrun.status.medicalleave;

import com.github.jettyrun.LeavePermit;
import com.github.jettyrun.status.handle.StatusHandler;

/**
 * Created by jetty on 18/1/9.
 */
public class MedicalPermitSubmitStatusHandler extends StatusHandler{

    protected void doHandler(LeavePermit leavePermit){
        System.out.println(String.format("user:%s--病假提交--leavePermit status:%s-%s",leavePermit.getUser(),leavePermit.getStatus().getStatus(),leavePermit.getStatus().getMemo()));
    }

}
