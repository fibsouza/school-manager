package com.schoolmanager.activity.repository;

import com.schoolmanager.activity.domain.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends MongoRepository<Activity,String> {
    List<Activity> findActivityByClassId(String classId);
    List<Activity> findActivityByClassIdAndStatus(String classId, String status);
}
