package com.schoolmanager.student.domain.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@SuperBuilder
public class Student extends Client {

    @Id
    private String studentId;
    private String classId;
}
