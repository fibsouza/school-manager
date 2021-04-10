package com.schoolmanager.teacher.application;

import com.schoolmanager.teacher.domain.Evaluation;
import com.schoolmanager.teacher.infraestructure.client.EvaluationClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EvaluationService {
    private final EvaluationClient client;

    public Evaluation submitGrade(Evaluation evaluation) {
        return client.submitGrade(evaluation);
    }
}
