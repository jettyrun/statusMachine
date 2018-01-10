package com.github.jettyrun.status.annualleave.ceo;

import com.github.jettyrun.LeavePermit;
import com.github.jettyrun.status.handle.StatusHandler;

/**
 * Created by jetty on 18/1/9.
 */
public class AnnualCEOPermitModifyStatusHandler extends StatusHandler{

    protected void doHandler(LeavePermit leavePermit){
        System.out.println(String.format("user:%s--ceo退回年休假单补充材料--leavePermit status:%s",leavePermit.getUser()));
    }

}
