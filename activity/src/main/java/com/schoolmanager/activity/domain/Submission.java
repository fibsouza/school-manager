package com.schoolmanager.activity.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Submission {

    @Id
    @GeneratedValue
    private String id;

    @NotEmpty
    private String studentId;

    @NotEmpty
    private String activityId;

    @NotEmpty
    private List<Answer> answers;
    @CreatedDate
    private Date submissionDate;
}
