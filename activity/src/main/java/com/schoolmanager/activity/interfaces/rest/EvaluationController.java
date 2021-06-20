package com.schoolmanager.activity.interfaces.rest;

import com.schoolmanager.activity.application.EvaluationService;
import com.schoolmanager.activity.domain.Evaluation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/activity")
@Api(value = "School Management - Evaluation API")
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationService service;

    @ApiOperation(value = "Send new evaluation", notes = "This endpoint is used to teachers to send evaluation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sended evaluation successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 500, message = "Unexpected error"),
            @ApiResponse(code = 502, message = "Communication failure")})
    @PostMapping(value="/evaluation",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Evaluation> createActivity(@RequestBody Evaluation evaluation){
        Evaluation response = service.submitGrade(evaluation);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
