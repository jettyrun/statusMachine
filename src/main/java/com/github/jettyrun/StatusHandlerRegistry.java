package com.github.jettyrun;

import com.github.jettyrun.leavepermit.LeavePermitType;
import com.github.jettyrun.status.Status;
import com.github.jettyrun.status.handle.StatusHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jetty on 18/1/9.
 */
public class StatusHandlerRegistry {

    private static Map<String,StatusHandler> statusHandlerMap;

    static {
        statusHandlerMap=new ConcurrentHashMap<String, StatusHandler>();
    }

    private StatusHandlerRegistry(){

    }

    private static String getKey(LeavePermitType leavePermitType,Status status){
        return String.format("%s@-@%s",leavePermitType.getType(),status.name());
    }

    /**
     * 注册状态处理类
     * @param leavePermitType  请假类型
     * @param status           请假状态
     * @param statusHandler    状态处理对象
     */
    public static void registryStatusHandler(LeavePermitType leavePermitType,Status status,StatusHandler statusHandler){
        statusHandlerMap.put(getKey(leavePermitType,status),statusHandler);
    }

    /**
     * 获取状态处理类
     * @param leavePermitType  请假类型
     * @param status            请假状态
     * @return StatusHandler
     */
    public static StatusHandler acquireStatusHandler(LeavePermitType leavePermitType,Status status){
        return statusHandlerMap.get(getKey(leavePermitType,status));
    }

}
