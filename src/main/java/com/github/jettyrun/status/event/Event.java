package com.github.jettyrun.status.event;

/**
 * Created by jetty on 18/1/8.
 */
public enum Event {

    AGREE("agree","同意"),
    DISSAGREE("disagree","不同意"),
    MODIFY("modify","修改")
    ;

    private String type;
    private String memo;

    private Event(String type, String memo){
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
