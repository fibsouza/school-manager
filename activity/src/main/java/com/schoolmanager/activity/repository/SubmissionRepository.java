package com.schoolmanager.activity.repository;

import com.schoolmanager.activity.domain.Activity;
import com.schoolmanager.activity.domain.Submission;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubmissionRepository extends MongoRepository<Submission, String> {
    Optional<Activity> findByActivityId(String activityId);
}
