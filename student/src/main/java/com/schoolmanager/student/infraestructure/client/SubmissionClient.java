package com.schoolmanager.student.infraestructure.client;

import com.schoolmanager.student.domain.Submission;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="submission", url="${integration.base.url}")
public interface SubmissionClient {

    @PostMapping(value = "/api/activity/v1/submission",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    Submission submitAnsewers(@RequestBody Submission submission);
}
