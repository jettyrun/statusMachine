package com.github.jettyrun.status.annualleave;

import com.github.jettyrun.LeavePermit;
import com.github.jettyrun.engine.StatusMachineEngine;
import com.github.jettyrun.status.handle.StatusHandler;
import com.github.jettyrun.status.machine.factory.StatusMachineFactory;

/**
 * Created by jetty on 18/1/9.
 */
public class AnnualPermitFailStatusHandler extends StatusHandler{

    protected void doHandler(LeavePermit leavePermit){
        System.out.println(String.format("user:%s--请年休假失败--leavePermit status:%s",leavePermit.getUser(),leavePermit.getStatus().getStatus()));
    }

    @Override
    protected void after(LeavePermit leavePermit){

    }
}
