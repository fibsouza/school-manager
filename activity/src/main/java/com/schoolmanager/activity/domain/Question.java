package com.schoolmanager.activity.domain;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    private Integer number;

    private String descrition;

    @ApiModelProperty(notes = "There is a max ponctuation to every question")
    private Integer targetScore;
}
