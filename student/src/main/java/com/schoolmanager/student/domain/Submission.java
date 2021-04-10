package com.schoolmanager.student.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Submission {

    @NotEmpty
    private String studentId;

    @NotEmpty
    private String activityId;

    @NotEmpty
    private List<Answer> answers;

    private Date submissionDate;
}
