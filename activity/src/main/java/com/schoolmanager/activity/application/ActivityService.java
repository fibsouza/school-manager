package com.schoolmanager.activity.application;

import com.schoolmanager.activity.domain.Activity;
import com.schoolmanager.activity.domain.ActivityResponse;
import com.schoolmanager.activity.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository repository;

    public Activity create(Activity activity){
        log.info("Activity: "+ activity.toString());
        return repository.save(activity);
    }

    public Activity update(String id, Activity activity){
        Optional<Activity> activityOpt = repository.findById(id);

        if(activityOpt.isPresent()){
            Activity act = activityOpt.get();
            act.setTitle(activity.getTitle());
            act.setSubject(activity.getSubject());
            act.setDeadline(activity.getDeadline());
            act.setVisibility(activity.getVisibility());
            return repository.save(act);
        }
        return null;
    }
    public void delete(String id){
        repository.deleteById(id);
    }

    public List<ActivityResponse> getAllActivities() {
        List<Activity> activityList = repository.findAll();

        return activityMapper(activityList);
    }

    public List<ActivityResponse> getActivitiesByClass(String classId){
        List<Activity> activityList = repository.findActivityByClassId(classId);

        return activityMapper(activityList);
    }

    public List<ActivityResponse> getActivitiesByClassAndStatus(String classId, String status){
        List<Activity> activityList = repository.findActivityByClassIdAndStatus(classId, status);

        return activityMapper(activityList);
    }

    public List<ActivityResponse> activityMapper(List<Activity> activityList){
        List<ActivityResponse> activityResponses = new ArrayList<>();

        for (Activity i : activityList){
            ActivityResponse activityResponse = new ActivityResponse();
            activityResponse.setId(i.getId());
            activityResponse.setTitle(i.getTitle());
            activityResponse.setSubject(i.getSubject());
            activityResponse.setClassId(i.getClassId());
            activityResponse.setDeadline(i.getDeadline());
            activityResponse.setStatus(i.getStatus());
            activityResponse.setQuestions(i.getQuestions());

            activityResponses.add(activityResponse);
        }

        return activityResponses;
    }

}
