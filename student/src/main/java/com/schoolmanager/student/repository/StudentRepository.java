package com.schoolmanager.student.repository;

import com.schoolmanager.student.domain.Student.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findStudentByClassId(String classId);
    Optional<Student> findStudentByCpf(String cpf);
}
