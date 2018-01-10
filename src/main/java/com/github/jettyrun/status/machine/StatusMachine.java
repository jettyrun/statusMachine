package com.github.jettyrun.status.machine;

import com.github.jettyrun.status.Status;
import com.github.jettyrun.status.event.Event;

/**
 * Created by jetty on 18/1/8.
 */
public interface StatusMachine {

     public Status getNextStatus(Status status,Event event);

}
