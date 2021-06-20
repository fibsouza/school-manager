package com.schoolmanager.student.interfaces.rest;

import com.schoolmanager.student.application.StudentService;
import com.schoolmanager.student.domain.Student.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/student")
@Api(value = "School Management - Student API")
public class StudentController {

    private final StudentService service;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 201, message = "Create new register successfully"),
            @ApiResponse(code = 202, message = "Update register successfully"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 500, message = "Unexpected error"),
            @ApiResponse(code = 502, message = "Communication failure")})


    @ApiOperation(value = "Create new student", notes = "This endpoint is used to create new student register")
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student studentResponse = service.create(student);
        if(studentResponse == null){
           ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student was not created because they already exists!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponse);
    }

    @ApiOperation(value = "Update an student", notes = "This endpoint is used to update student register")
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> update(@RequestHeader("cpf") String cpf, @RequestBody Student student){
        Student studentResponse = service.update(cpf , student);
        if(studentResponse == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentResponse, HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Find by cpf", notes = "This endpoint is used to search student by cpf")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getStudentById(@RequestHeader("cpf") String cpf){
        Optional<Student> student = service.getStudentById(cpf);
        student.ifPresent(value -> ResponseEntity.status(HttpStatus.OK).body(value));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
    }

    @ApiOperation(value = "Find all", notes = "This endpoint is used to search all students")
    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = service.getAllStudents();
        if(students == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students, HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Find by classId", notes = "This endpoint is used to search student based on classId")
    @GetMapping(value="/class", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getStudentsByClass(@RequestHeader("classId") String classId){
        List<Student> students = service.getStudentsByClass(classId);

        if(students == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students, HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Delete student", notes = "This endpoint is used to delete an student register")
    @DeleteMapping()
    public ResponseEntity<HttpStatus> deleteStudent(@RequestHeader("cpf") String cpf){
        service.delete(cpf);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
