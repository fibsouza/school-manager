package com.schoolmanager.student.interfaces.rest;

import com.schoolmanager.student.application.StudentService;
import com.schoolmanager.student.domain.Student.Student;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService service;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id){
        Optional<Student> student = service.getStudentById(id);
        if(!student.isPresent()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(student.get());
    }
}
