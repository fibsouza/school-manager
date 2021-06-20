package com.schoolmanager.student.application;

import com.schoolmanager.student.domain.Student.Student;
import com.schoolmanager.student.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public Student create(Student student) {
        Optional<Student> studentResponse =  repository.findStudentByCpf(student.getCpf());
        if (studentResponse.isPresent()){
            return null;
        }
        log.info("Class: {}", student.getClassId());
        return repository.save(student);
    }

    public Student update(String cpf, Student student) {
        Optional<Student> studentResponse =  repository.findStudentByCpf(cpf);
        if (studentResponse.isPresent()){
            return repository.save(student);
        }
        return null;
    }

    public Optional<Student> getStudentById(String cpf) {
        return repository.findStudentByCpf(cpf);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public List<Student> getStudentsByClass(String classId) {
        return repository.findStudentByClassId(classId);
    }

    public void delete(String cpf) {
        Optional<Student> studentResponse =  repository.findStudentByCpf(cpf);
        studentResponse.ifPresent(repository::delete);
    }
}
