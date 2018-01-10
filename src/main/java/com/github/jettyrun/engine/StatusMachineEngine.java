package com.github.jettyrun.engine;

import com.github.jettyrun.LeavePermit;
import com.github.jettyrun.status.handle.LeavePermitHandler;
import com.google.common.eventbus.EventBus;

/**
 * Created by jetty on 18/1/9.
 */
public class StatusMachineEngine {

    private static EventBus eventBus;
    static{
        eventBus = new EventBus();
    }

    /**
     * 发布一条假单
     * @param leavePermit
     */
    public static void post(LeavePermit leavePermit) {
        eventBus.post(leavePermit);
    }

    /**
     * 假单处理类
     * @param statusLeavePermitHandler
     */
    public static void addListener(LeavePermitHandler statusLeavePermitHandler) {
        eventBus.register(statusLeavePermitHandler);
    }
}


