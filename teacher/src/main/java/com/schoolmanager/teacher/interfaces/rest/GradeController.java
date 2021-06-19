package com.schoolmanager.teacher.interfaces.rest;

import com.schoolmanager.teacher.application.EvaluationService;
import com.schoolmanager.teacher.domain.Evaluation;
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
@RequestMapping(value = "/api/teacher/v1")
@Api(value = "School Management - Teacher API")
@RequiredArgsConstructor
public class GradeController {

    private final EvaluationService service;

    @ApiOperation(value = "New submit grade", notes = "This endpoint is used to teacher to submit your evalution")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sended new evaluation successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 500, message = "Unexpected error"),
            @ApiResponse(code = 502, message = "Communication failure")})
    @PostMapping(value="/submitGrade",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Evaluation> createActivity(@RequestBody Evaluation evaluation){
        Evaluation response = service.submitGrade(evaluation);
        if(response == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
