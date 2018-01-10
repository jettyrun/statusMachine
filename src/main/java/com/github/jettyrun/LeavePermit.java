package com.github.jettyrun;

import com.github.jettyrun.leavepermit.LeavePermitType;
import com.github.jettyrun.status.Status;
import com.github.jettyrun.status.event.Event;

/**
 * Created by jetty on 18/1/9.
 */
public class LeavePermit {
    private Status status;
    private LeavePermitType leavePermitType;
    private Event event;
    private String user;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LeavePermitType getLeavePermitType() {
        return leavePermitType;
    }

    public void setLeavePermitType(LeavePermitType leavePermitType) {
        this.leavePermitType = leavePermitType;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
