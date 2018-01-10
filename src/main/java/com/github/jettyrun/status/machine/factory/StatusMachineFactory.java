package com.github.jettyrun.status.machine.factory;

import com.github.jettyrun.leavepermit.LeavePermitType;
import com.github.jettyrun.status.machine.AnnualLeaveStatusMachine;
import com.github.jettyrun.status.machine.MedicalLeaveStatusMachine;
import com.github.jettyrun.status.machine.StatusMachine;

/**
 * Created by jetty on 18/1/9.
 */
public class StatusMachineFactory {

    private StatusMachineFactory(){

    }

    /**
     * 根据状态获取状态机
     * @param leavePermitType
     * @return 对应请假类型的状态机
     */
    public static StatusMachine getStatusMachine(LeavePermitType leavePermitType){
        switch (leavePermitType){
            case MEDICAL_LEAVE:
                return new MedicalLeaveStatusMachine();
            case ANNUAL_LEAVE:
                return new AnnualLeaveStatusMachine();
            default:
                throw new RuntimeException("未知类型");
        }
    }

}
