package com.schoolmanager.student.domain.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @NotEmpty
    private String addressDetail;
    @NotEmpty
    private String city;
    @NotEmpty
    private String zipcode;
    @NotEmpty
    private String country;
}
