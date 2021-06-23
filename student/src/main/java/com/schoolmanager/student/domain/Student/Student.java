package com.schoolmanager.student.domain.Student;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Student extends Client {

    @Id
    @GeneratedValue
    private String studentId;

    private String classId;

    public String getClassId() {
        if (this.classId == null) {
            return "not allocated";
        }
        return this.classId;
    }
}
