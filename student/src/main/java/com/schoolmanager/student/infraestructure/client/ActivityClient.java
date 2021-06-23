package com.schoolmanager.student.infraestructure.client;

import com.schoolmanager.student.domain.Activity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="activity", url="${integration.base.url}/api/v1/activity/activities")
public interface ActivityClient {

    @GetMapping(value = "/all",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    List<Activity> getAllActivities();

    @GetMapping(value = "/{classId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    List<Activity> getActivitiesByClass(@PathVariable String classId);

    @GetMapping(value = "/{classId}/{status}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    List<Activity> getActivitiesByClassAndStatus(@PathVariable String classId, @PathVariable String status);

}
