package com.github.jettyrun.status.annualleave.leader;

import com.github.jettyrun.LeavePermit;
import com.github.jettyrun.status.handle.StatusHandler;

/**
 * Created by jetty on 18/1/9.
 */
public class AnnualLeaderPermitModifyStatusHandler extends StatusHandler{

    protected void doHandler(LeavePermit leavePermit){
        System.out.println(String.format("user:%s--领导退回假单补充材料--leavePermit status:%s",leavePermit.getUser(),leavePermit.getStatus().getStatus()));
    }

}
