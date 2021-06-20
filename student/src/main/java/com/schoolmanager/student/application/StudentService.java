package com.schoolmanager.student.application;

import com.schoolmanager.student.domain.Student.Student;
import com.schoolmanager.student.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public Optional<Student> getStudentById(String id){
        Optional<Student>  student = repository.findById(id);
        return student;
    }
}
