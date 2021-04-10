package com.schoolmanager.activity.interfaces.stream;

import com.schoolmanager.activity.domain.Submission;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Publisher implements ActivityPublisher{

    @Override
    public void publish(Submission submission, Source source) {
        log.info(submission.toString());
        source.activityOutput().send(MessageBuilder.withPayload(submission).build());
    }
}
