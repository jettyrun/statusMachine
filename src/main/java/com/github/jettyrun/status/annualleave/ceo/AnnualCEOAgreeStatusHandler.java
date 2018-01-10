package com.github.jettyrun.status.annualleave.ceo;

import com.github.jettyrun.LeavePermit;
import com.github.jettyrun.status.handle.StatusHandler;

/**
 * Created by jetty on 18/1/9.
 */
public class AnnualCEOAgreeStatusHandler extends StatusHandler{

    protected void doHandler(LeavePermit leavePermit){
        System.out.println(String.format("user:%s--ceo同意休年休假--leavePermit status:%s",leavePermit.getUser(),leavePermit.getStatus().getStatus()));
    }

}
