package com.schoolmanager.student.interfaces.rest;

import com.schoolmanager.student.application.ActivityService;
import com.schoolmanager.student.domain.Activity;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/student/v1")
@Api(value = "School Management - Student API")
@AllArgsConstructor
public class ActivityController {

    private final ActivityService service;

    @GetMapping(value="/activities/all")
    public List<Activity> getAllActivities(){
        return service.getAllActivities();
    }

    @GetMapping(value="/activities/{classId}")
    public List<Activity> getActivitiesByClass(@PathVariable String classId){
        return service.getActivitiesByClass(classId);
    }

    @GetMapping(value="/activities/{classId}/{status}")
    public List<Activity> getActivitiesByClass(@PathVariable String classId, @PathVariable String status){
        return service.getActivitiesByClassAndStatus(classId, status);
    }

}
