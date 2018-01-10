package com.github.jettyrun.leavepermit;


/**
 * Created by jetty on 18/1/8.
 */
public enum LeavePermitType {

    ANNUAL_LEAVE("annual_leave","年/调休假"),
    CASUAL_LEAVE("casual_leave","事假"),
    MEDICAL_LEAVE("medical_leave","病假"),
    MARRIAGE_LEAVE("marriage_leave","婚假"),
    ;

    private String type;
    private String memo;

    private LeavePermitType(String type, String memo){
        this.type=type;
        this.memo=memo;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
