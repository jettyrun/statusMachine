package com.github.jettyrun.status.annualleave;

import com.github.jettyrun.LeavePermit;
import com.github.jettyrun.status.handle.StatusHandler;

/**
 * Created by jetty on 18/1/9.
 */
public class AnnualPermitSubmitStatusHandler extends StatusHandler{

    protected void doHandler(LeavePermit leavePermit){
        System.out.println(String.format("user:%s--提交年休假假单--leavePermit status:%s",leavePermit.getUser(),leavePermit.getStatus().getStatus()));
    }

}
