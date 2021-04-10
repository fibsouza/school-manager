package com.schoolmanager.teacher.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Evaluation {

    private String submitionId;
    private Double grade;
    private String situation;
}
