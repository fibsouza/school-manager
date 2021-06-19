package com.schoolmanager.activity.interfaces.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface Source {

    String ACT = "activity";

    @Output(ACT)
    public MessageChannel activityOutput();
}
