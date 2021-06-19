package com.schoolmanager.student.application;

import com.schoolmanager.student.domain.Activity;
import com.schoolmanager.student.infraestructure.client.ActivityClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ActivityService {

    private final ActivityClient client;

    public List<Activity> getAllActivities() {
        return client.getAllActivities();
    }

    public List<Activity> getActivitiesByClass(String classId) {
        return client.getActivitiesByClass(classId);
    }

    public List<Activity> getActivitiesByClassAndStatus(String classId, String status) {
        return client.getActivitiesByClassAndStatus(classId, status);
    }
}
