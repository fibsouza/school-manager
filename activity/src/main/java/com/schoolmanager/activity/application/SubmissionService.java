package com.schoolmanager.activity.application;

import com.schoolmanager.activity.domain.Activity;
import com.schoolmanager.activity.domain.Submission;
import com.schoolmanager.activity.repository.ActivityRepository;
import com.schoolmanager.activity.repository.SubmissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubmissionService {

    private final SubmissionRepository repository;
    private final ActivityRepository activityRepository;

    public Submission create(Submission submission){
        log.info("Submission: "+ submission.toString());
        Optional<Activity> activity = activityRepository.findById(submission.getActivityId());
        if(activity.isPresent()){
            return repository.save(submission);
        }
        return null;
    }
}
