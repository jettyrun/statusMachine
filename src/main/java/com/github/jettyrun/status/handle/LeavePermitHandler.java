package com.github.jettyrun.status.handle;

import com.github.jettyrun.LeavePermit;
import com.github.jettyrun.StatusHandlerRegistry;
import com.github.jettyrun.leavepermit.LeavePermitType;
import com.github.jettyrun.status.Status;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

/**
 * Created by jetty on 18/1/9.
 */
public class LeavePermitHandler {

    //处理假单 注解代表可以接受到StatusMachineEngine发布的假单
    @Subscribe
    @AllowConcurrentEvents
    public void handle(LeavePermit leavePermit){
        //获取到状态处理类，然后去处理 handler为StatusHandler的入口
        getStatusHandler(leavePermit).handle(leavePermit);
    }

    /**
     * 根据假单获取StatusHandler 状态处理对象
     * @param leavePermit
     * @return
     */
    public static StatusHandler getStatusHandler(LeavePermit leavePermit){
        return StatusHandlerRegistry.acquireStatusHandler(leavePermit.getLeavePermitType(),leavePermit.getStatus());
    }

}
