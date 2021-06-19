package com.schoolmanager.student.domain.Student;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Address {
    private String addressDetail;
    private String city;
    private String zipcode;
    private String country;
}
