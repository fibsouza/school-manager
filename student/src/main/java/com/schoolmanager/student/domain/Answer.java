package com.schoolmanager.student.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @NotEmpty
    private Integer number;
    @NotEmpty
    private String description;
}
