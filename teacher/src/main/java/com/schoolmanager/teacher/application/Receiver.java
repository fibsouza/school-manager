package com.schoolmanager.teacher.application;

import com.schoolmanager.teacher.domain.SubmissionRequest;
import com.schoolmanager.teacher.repository.SubmissionRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@EnableBinding(Sink.class)
@RequiredArgsConstructor
public class Receiver {

    private final SubmissionRequestRepository repository;

    @StreamListener(Sink.INPUT)
    public void readMessage(SubmissionRequest submissionRequest) {

        //implementar envio de e-mail

       log.info("NOTIFICACAO DE SUBMIT RECEBIDA");
        repository.save(submissionRequest);
    }
}
