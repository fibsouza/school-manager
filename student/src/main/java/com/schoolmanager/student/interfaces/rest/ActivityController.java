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
@RequestMapping(value = "/api/v1/student/activities")
@Api(value = "School Management - Student API")
@AllArgsConstructor
public class ActivityController {

    private final ActivityService service;

    @GetMapping(value="/all")
    public ResponseEntity<List<Activity>> getAllActivities(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllActivities());
    }

    @GetMapping(value="/{classId}")
    public ResponseEntity<List<Activity>> getActivitiesByClass(@PathVariable String classId){
        return ResponseEntity.status(HttpStatus.OK).body(service.getActivitiesByClass(classId));
    }

    @GetMapping(value="/{classId}/{status}")
    public ResponseEntity<List<Activity>>getActivitiesByClass(@PathVariable String classId, @PathVariable String status){
        return ResponseEntity.status(HttpStatus.OK).body(service.getActivitiesByClassAndStatus(classId, status));
    }

}
