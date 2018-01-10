package com.github.jettyrun.status.annualleave;

import com.github.jettyrun.LeavePermit;
import com.github.jettyrun.status.handle.StatusHandler;

/**
 * Created by jetty on 18/1/9.
 */
public class AnnualPermitSuccessStatusHandler extends StatusHandler{

    @Override
    protected void doHandler(LeavePermit leavePermit){
        System.out.println(String.format("user:%s--请年休假假成功--leavePermit status:%s",leavePermit.getUser(),leavePermit.getStatus().getStatus(),leavePermit.getStatus().getMemo()));
    }

    @Override
    protected void after(LeavePermit leavePermit){

    }

}
