package com.schoolmanager.student.domain.Student;

import com.schoolmanager.student.infraestructure.validation.Telephone.Telephone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotEmpty;

@Slf4j
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @NotEmpty
    @Telephone
    private String telephone;
}
