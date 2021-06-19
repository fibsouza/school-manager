package com.schoolmanager.teacher.infraestructure.client;

import com.schoolmanager.teacher.domain.Evaluation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="evaluation", url="${integration.base.url}")
public interface EvaluationClient {

    @PostMapping(value = "/api/activity/v1/evaluation",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    Evaluation submitGrade(@RequestBody Evaluation evaluation);
}
