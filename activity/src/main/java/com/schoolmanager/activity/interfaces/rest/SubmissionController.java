package com.schoolmanager.activity.interfaces.rest;

import com.schoolmanager.activity.application.ActivityService;
import com.schoolmanager.activity.application.NotificationActivityService;
import com.schoolmanager.activity.application.SubmissionService;
import com.schoolmanager.activity.domain.Activity;
import com.schoolmanager.activity.domain.Submission;
import com.schoolmanager.activity.interfaces.stream.Publisher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/activity/v1")
@Api(value = "School Management - Activity API")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService service;
    private final NotificationActivityService notificationActivityService;

    @ApiOperation(value = "New submission", notes = "This endpoint is used to students to submit your anserws")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Create new submission successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 500, message = "Unexpected error"),
            @ApiResponse(code = 502, message = "Communication failure")})
    @PostMapping(value="/submission",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Submission> createActivity(@RequestBody Submission submission){
        Submission response = service.create(submission);
        if(response == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        notificationActivityService.publish(submission);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
