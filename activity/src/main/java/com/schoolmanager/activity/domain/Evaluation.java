package com.schoolmanager.activity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Evaluation {
    private String submitionId;
    private Double grade;
    private String situation;
}
