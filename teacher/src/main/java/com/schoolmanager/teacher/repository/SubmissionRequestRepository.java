package com.schoolmanager.teacher.repository;

import com.schoolmanager.teacher.domain.SubmissionRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRequestRepository extends MongoRepository<SubmissionRequest, String> {
}
