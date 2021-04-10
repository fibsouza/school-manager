package com.schoolmanager.activity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.util.Date;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class FinalEvaluation {
    @Id
    @GeneratedValue
    private String id;

    private String submissionId;

    private Integer score;
    
    @CreatedDate
    private Date createdAt;
}
