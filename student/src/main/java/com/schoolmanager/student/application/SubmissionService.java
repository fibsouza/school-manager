package com.schoolmanager.student.application;

import com.schoolmanager.student.domain.Submission;
import com.schoolmanager.student.infraestructure.client.SubmissionClient;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SubmissionService {

    private final SubmissionClient client;

    public Submission submitAnsewers(Submission submission){
        log.info("Submission: "+ submission.toString());
        return client.submitAnsewers(submission);
    }
}
