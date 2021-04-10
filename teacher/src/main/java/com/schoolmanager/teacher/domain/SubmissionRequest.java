package com.schoolmanager.teacher.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionRequest {

    private String id;
    private String studentId;
    private String activityId;
    private List<Answer> answers;
    private Date submissionDate;
}
