package com.schoolmanager.student.repository;

import com.schoolmanager.student.domain.Student.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
