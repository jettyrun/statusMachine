package com.github.jettyrun;

import com.github.jettyrun.engine.StatusMachineEngine;
import com.github.jettyrun.leavepermit.LeavePermitType;
import com.github.jettyrun.status.Status;
import com.github.jettyrun.status.annualleave.AnnualPermitFailStatusHandler;
import com.github.jettyrun.status.annualleave.AnnualPermitSubmitStatusHandler;
import com.github.jettyrun.status.annualleave.AnnualPermitSuccessStatusHandler;
import com.github.jettyrun.status.annualleave.ceo.AnnualCEOAgreeStatusHandler;
import com.github.jettyrun.status.annualleave.ceo.AnnualCEODisAgreeStatusHandler;
import com.github.jettyrun.status.annualleave.ceo.AnnualCEOPermitModifyStatusHandler;
import com.github.jettyrun.status.annualleave.ceo.AnnualCEOPermitingStatusHandler;
import com.github.jettyrun.status.annualleave.leader.AnnualLeaderAgreeStatusHandler;
import com.github.jettyrun.status.annualleave.leader.AnnualLeaderDisAgreeStatusHandler;
import com.github.jettyrun.status.annualleave.leader.AnnualLeaderPermitModifyStatusHandler;
import com.github.jettyrun.status.annualleave.leader.AnnualLeaderPermitingStatusHandler;
import com.github.jettyrun.status.event.Event;
import com.github.jettyrun.status.handle.LeavePermitHandler;
import com.github.jettyrun.status.medicalleave.MedicalPermitFailStatusHandler;
import com.github.jettyrun.status.medicalleave.MedicalPermitSubmitStatusHandler;
import com.github.jettyrun.status.medicalleave.MedicalPermitSuccessStatusHandler;
import com.github.jettyrun.status.medicalleave.hr.MedicalHrAgreeStatusHandler;
import com.github.jettyrun.status.medicalleave.hr.MedicalHrDisAgreeStatusHandler;
import com.github.jettyrun.status.medicalleave.hr.MedicalHrPermitModifyStatusHandler;
import com.github.jettyrun.status.medicalleave.hr.MedicalHrPermitingStatusHandler;
import com.github.jettyrun.status.medicalleave.leader.MedicalLeaderAgreeStatusHandler;
import com.github.jettyrun.status.medicalleave.leader.MedicalLeaderDisAgreeStatusHandler;
import com.github.jettyrun.status.medicalleave.leader.MedicalLeaderPermitModifyStatusHandler;
import com.github.jettyrun.status.medicalleave.leader.MedicalLeaderPermitingStatusHandler;

/**
 * Created by jetty on 18/1/9.
 */
public class Main {

    public static void main(String[] args) {
        //注册年休假的状态和对应状态的处理类StatusHandler。
        registryAnnualPermitStatusHandler();
        //注册病假的状态和对应状态的处理类StatusHandler。
        registryMedicalPermitStatusHandler();

        LeavePermitHandler leavePermitHandler=new LeavePermitHandler();
        //状态机引擎接受事件处理类
        StatusMachineEngine.addListener(leavePermitHandler);
        //生成假单
        LeavePermit leavePermit=new LeavePermit();
        leavePermit.setLeavePermitType(LeavePermitType.ANNUAL_LEAVE);
        leavePermit.setStatus(Status.PERMIT_SUBMIT);
        leavePermit.setUser("jettyrun");
        //假单交给引擎去执行
        StatusMachineEngine.post(leavePermit);

        System.out.println("----- 分割线 代表假条需要领导审批了，领导给个通过意见,然后状态机接着走-------");
        leavePermit.setEvent(Event.AGREE);
        StatusMachineEngine.post(leavePermit);
        System.out.println("----- 分割线 代表假条需要ceo审批了，ceo给个通过意见,然后状态机接着走-------");
        leavePermit.setEvent(Event.AGREE);
        StatusMachineEngine.post(leavePermit);
        System.out.println("--->>>>>>>>>end<<<<<<<<-------");


        LeavePermit leavePermit2=new LeavePermit();
        leavePermit2.setLeavePermitType(LeavePermitType.MEDICAL_LEAVE);
        leavePermit2.setStatus(Status.PERMIT_SUBMIT);
        leavePermit2.setUser("jettyrun2");
        StatusMachineEngine.post(leavePermit2);

        System.out.println("----- 分割线 代表假条需要领导审批了，领导给个通过意见,然后状态机接着走-------");
        leavePermit2.setEvent(Event.AGREE);
        StatusMachineEngine.post(leavePermit2);


        System.out.println("----- 分割线 代表假条需要hr审批了，hr给个通过意见,然后状态机接着走-------");
        leavePermit2.setEvent(Event.AGREE);
        StatusMachineEngine.post(leavePermit2);
        System.out.println("--->>>>>>>>>end<<<<<<<<-------");



        LeavePermit leavePermit3=new LeavePermit();
        leavePermit3.setLeavePermitType(LeavePermitType.MEDICAL_LEAVE);
        leavePermit3.setStatus(Status.PERMIT_SUBMIT);
        leavePermit3.setUser("jettyrun3");
        StatusMachineEngine.post(leavePermit3);

        System.out.println("----- 分割线 代表假条需要领导审批了，领导给个通过意见,然后状态机接着走-------");
        leavePermit3.setEvent(Event.DISSAGREE);
        StatusMachineEngine.post(leavePermit3);
        System.out.println("--->>>>>>>>>end<<<<<<<<-------");

    }


    public static void registryAnnualPermitStatusHandler() {

        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.ANNUAL_LEAVE, Status.PERMIT_SUBMIT, new AnnualPermitSubmitStatusHandler());

        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.ANNUAL_LEAVE, Status.LEADER_PERMIT_AGREE, new AnnualLeaderAgreeStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.ANNUAL_LEAVE, Status.LEADER_PERMIT_DISAGREE, new AnnualLeaderDisAgreeStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.ANNUAL_LEAVE, Status.LEADER_PERMIT_MODIFY, new AnnualLeaderPermitModifyStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.ANNUAL_LEAVE, Status.LEADER_PERMITING, new AnnualLeaderPermitingStatusHandler());

        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.ANNUAL_LEAVE, Status.CEO_PERMIT_AGREE, new AnnualCEOAgreeStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.ANNUAL_LEAVE, Status.CEO_PERMIT_DISAGREE, new AnnualCEODisAgreeStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.ANNUAL_LEAVE, Status.CEO_PERMIT_MODIFY, new AnnualCEOPermitModifyStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.ANNUAL_LEAVE, Status.CEO_PERMITING, new AnnualCEOPermitingStatusHandler());

        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.ANNUAL_LEAVE, Status.PERMIT_SUCCESS, new AnnualPermitSuccessStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.ANNUAL_LEAVE, Status.PERMIT_FAIL, new AnnualPermitFailStatusHandler());
    }



    public static void registryMedicalPermitStatusHandler() {

        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.MEDICAL_LEAVE, Status.PERMIT_SUBMIT, new MedicalPermitSubmitStatusHandler());

        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.MEDICAL_LEAVE, Status.LEADER_PERMIT_AGREE, new MedicalLeaderAgreeStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.MEDICAL_LEAVE, Status.LEADER_PERMIT_DISAGREE, new MedicalLeaderDisAgreeStatusHandler
                ());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.MEDICAL_LEAVE, Status.LEADER_PERMIT_MODIFY, new MedicalLeaderPermitModifyStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.MEDICAL_LEAVE, Status.LEADER_PERMITING, new MedicalLeaderPermitingStatusHandler());

        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.MEDICAL_LEAVE, Status.HR_PERMIT_AGREE, new MedicalHrAgreeStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.MEDICAL_LEAVE, Status.HR_PERMIT_DISAGREE, new MedicalHrDisAgreeStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.MEDICAL_LEAVE, Status.HR_PERMIT_MODIFY, new MedicalHrPermitModifyStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.MEDICAL_LEAVE, Status.HR_PERMITING, new MedicalHrPermitingStatusHandler());

        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.MEDICAL_LEAVE, Status.PERMIT_SUCCESS, new MedicalPermitSuccessStatusHandler());
        StatusHandlerRegistry.registryStatusHandler(LeavePermitType.MEDICAL_LEAVE, Status.PERMIT_FAIL, new MedicalPermitFailStatusHandler());
    }
}
