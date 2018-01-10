package com.github.jettyrun.status.handle;

import com.github.jettyrun.LeavePermit;

/**
 * Created by jetty on 18/1/9.
 */
public interface AbstractStatusHandler {

    public void handle(LeavePermit leavePermit);

}
