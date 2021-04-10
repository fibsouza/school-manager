package com.schoolmanager.activity.domain;

import lombok.*;

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
