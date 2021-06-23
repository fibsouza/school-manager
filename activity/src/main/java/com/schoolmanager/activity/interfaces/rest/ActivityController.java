package com.schoolmanager.activity.interfaces.rest;

import com.schoolmanager.activity.application.ActivityService;
import com.schoolmanager.activity.domain.Activity;
import com.schoolmanager.activity.domain.ActivityResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/activity/activities")
@Api(value = "School Management - Activity API")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService service;

    @ApiOperation(value = "Create new activity", notes = "This endpoint is used to teachers to create new activities")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Create new activity successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 500, message = "Unexpected error"),
            @ApiResponse(code = 502, message = "Communication failure")})
    @PostMapping(value="/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity){
        Activity activityResponse = service.create(activity);
        return ResponseEntity.status(HttpStatus.CREATED).body(activityResponse);
    }

    @ApiOperation(value = "Update an activity", notes = "This endpoint is used to teachers to update activities")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Update activity successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 404, message = "Activity not found"),
            @ApiResponse(code = 500, message = "Unexpected error"),
            @ApiResponse(code = 502, message = "Communication failure")})
    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Activity> update(@PathVariable String id, @RequestBody Activity activity){
        Activity response = service.update(id , activity);
        if(response == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping(value="/all")
    public ResponseEntity<List<ActivityResponse>> getAllActivities(){
        List<ActivityResponse> activityResponse = service.getAllActivities();
        if(activityResponse == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(activityResponse, HttpStatus.ACCEPTED);
    }

    @GetMapping(value="/{classId}")
    public ResponseEntity<List<ActivityResponse>> getActivitiesByClass(@PathVariable String classId){
        List<ActivityResponse> activityResponse = service.getActivitiesByClass(classId);

        if(activityResponse == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(activityResponse, HttpStatus.ACCEPTED);
    }

    @GetMapping(value="/{classId}/{status}")
    public ResponseEntity<List<ActivityResponse>> getActivitiesByClass(@PathVariable String classId, @PathVariable String status){
        List<ActivityResponse> activityResponse =  service.getActivitiesByClassAndStatus(classId, status);

        if(activityResponse == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(activityResponse, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/activities/{id}")
    public ResponseEntity deleteActivity(@PathVariable("id") String id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
