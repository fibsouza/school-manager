package com.schoolmanager.activity.application;

import com.schoolmanager.activity.domain.Activity;
import com.schoolmanager.activity.domain.Evaluation;
import com.schoolmanager.activity.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationRepository repository;
    public Evaluation submitGrade(Evaluation evaluation){
        log.info("Evaluation: "+ evaluation.toString());
        return repository.save(evaluation);
    }
}
