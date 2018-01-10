package com.github.jettyrun.status.handle;

import com.github.jettyrun.LeavePermit;
import com.github.jettyrun.engine.StatusMachineEngine;
import com.github.jettyrun.status.machine.factory.StatusMachineFactory;

/**
 * Created by jetty on 18/1/9.
 */
public abstract class StatusHandler implements AbstractStatusHandler{

    protected void before(LeavePermit leavePermit){

    }


    public void handle(LeavePermit leavePermit){
        before(leavePermit);
        doHandler(leavePermit);
        after(leavePermit);
    }

    protected abstract void doHandler(LeavePermit leavePermit);


    protected void after(LeavePermit leavePermit){
        goNextStatusHandler(leavePermit);
    }

    protected void goNextStatusHandler(LeavePermit leavePermit){
        //获取下一个状态
        leavePermit.setStatus(StatusMachineFactory.getStatusMachine(leavePermit.getLeavePermitType()).getNextStatus(leavePermit.getStatus(),leavePermit.getEvent()));
        //状态机引擎去处理该假单
        StatusMachineEngine.post(leavePermit);
    }
}
