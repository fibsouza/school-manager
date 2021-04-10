package com.schoolmanager.activity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityResponse {
    private String id;

    private String title;

    private String subject;

    private String classId;

    private Date deadline;

    private String status;

    private List<Question> questions;
}
