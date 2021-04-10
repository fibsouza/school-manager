package com.schoolmanager.activity.interfaces.stream;

import com.schoolmanager.activity.domain.Submission;

public interface ActivityPublisher {

    void publish(Submission submission, Source source);
}
