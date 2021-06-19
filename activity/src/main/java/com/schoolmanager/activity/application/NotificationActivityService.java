package com.schoolmanager.activity.application;

import com.schoolmanager.activity.domain.Submission;
import com.schoolmanager.activity.interfaces.stream.Publisher;
import com.schoolmanager.activity.interfaces.stream.Source;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableBinding(Source.class)
@AllArgsConstructor
public class NotificationActivityService {

    private final Publisher publisher;
    private final Source source;

    public void publish(Submission submission) {

         publisher.publish(submission, source);

    }
}
