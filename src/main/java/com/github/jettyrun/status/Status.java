package com.github.jettyrun.status;

/**
 * Created by jetty on 18/1/8.
 */
public enum Status {
    //提交假单
    PERMIT_SUBMIT("permitSubmit","提交假单"),
    //领导审批
    LEADER_PERMITING("leaderPermiting","领导审批中"),
    LEADER_PERMIT_AGREE("leaderAgree","领导同意"),
    LEADER_PERMIT_DISAGREE("leaderDisAgree","领导不同意"),
    LEADER_PERMIT_MODIFY("leaderModify","领导觉得需要补充材料重修修改"),

    //hr审批
    HR_PERMITING("hrPermiting","hr审批中"),
    HR_PERMIT_AGREE("hrAgree","hr同意"),
    HR_PERMIT_DISAGREE("hrDisAgree","hr不同意"),
    HR_PERMIT_MODIFY("hrModify","hr觉得需要补充材料重修修改"),
    //ceo审批
    CEO_PERMITING("ceoPermiting","ceo审批中"),
    CEO_PERMIT_AGREE("ceoAgree","ceo同意"),
    CEO_PERMIT_DISAGREE("ceoDisAgree","ceo不同意"),
    CEO_PERMIT_MODIFY("ceoModify","ceo觉得需要补充材料重修修改"),

    //最终请假状态
    PERMIT_SUCCESS("permitSuccess","请假成功"),
    PERMIT_FAIL("permitFail","请假失败")
    ;

    private String status;
    private String memo;

    private Status(String status,String memo){
        this.status=status;
        this.memo=memo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
