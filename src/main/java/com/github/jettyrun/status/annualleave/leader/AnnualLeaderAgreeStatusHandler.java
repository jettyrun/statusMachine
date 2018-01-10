package com.github.jettyrun.status.annualleave.leader;

import com.github.jettyrun.LeavePermit;
import com.github.jettyrun.status.handle.StatusHandler;

/**
 * Created by jetty on 18/1/9.
 */
public class AnnualLeaderAgreeStatusHandler extends StatusHandler{

    protected void doHandler(LeavePermit leavePermit){
        leavePermit.setEvent(null);
        System.out.println(String.format("user:%s--直线领导同意请年休假--leavePermit status:%s",leavePermit.getUser(),leavePermit.getStatus().getStatus()));
    }

}
