package com.schoolmanager.activity.repository;

import com.schoolmanager.activity.domain.Evaluation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends MongoRepository<Evaluation, String> {
}
