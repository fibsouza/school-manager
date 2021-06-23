package com.schoolmanager.student.interfaces.rest

import com.schoolmanager.student.application.StudentService
import com.schoolmanager.student.domain.Student.Address
import com.schoolmanager.student.domain.Student.Contact
import com.schoolmanager.student.domain.Student.Student
import groovy.json.JsonOutput
import org.springframework.http.MediaType
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class StudentControllerTest extends Specification{
    def service = Mock(StudentService)
    StudentController controller = new StudentController(service)
    def mockMvc = standaloneSetup(controller).build()

    @Shared
    def path = "/api/v1/student"

    @Shared
    def student = Student.builder()
            .studentId(UUID.randomUUID().toString())
            .cpf("46356554070")
            .name("Luiz Alberto Gregório")
            .email("greg@yahoo.com.br")
            .birthdate("12/04/1990")
            .contactList(
                    Arrays.asList(
                            Contact.builder().telephone("21 98821-9000").build(),
                            Contact.builder().telephone("21 91234-9000").build())
            )
            .address(Address.builder()
                    .addressDetail("Avenida das Américas 1.223")
                    .city("Rio de Janeiro")
                    .country("Brasil")
                    .zipcode("23456098")
                    .build())
            .build()


    @Unroll
    def "create new student"(){
        given:
        service.create(_) >> objectResponse

        when:
        def response = mockMvc.perform(post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonOutput.toJson(object))
        ).andReturn().response

        then:
        assert response.status == httpStatus

        where:
        object | objectResponse | httpStatus
        student | student       | 201
        student | null          | 204
        null    | null          | 400

    }

    @Unroll
    def "update student register"(){
        given:
        service.update(_, _) >> objectResponse

        when:
        def response = mockMvc.perform(put(path)
                .header("cpf", cpf)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonOutput.toJson(object))
        ).andReturn().response

        then:
        assert response.status == httpStatus

        where:
        object  | cpf               | objectResponse  | httpStatus
        student | "46356554070"     | student         | 202
        null    | "46356554070"     | null            | 400
        student | "46356554070"     | null            | 404
    }


    @Unroll
    def "find by id"(){
        given:
        service.getStudentById(cpf) >> objResponse
        when:
        def response = mockMvc.perform(get(path)
                .header("cpf", cpf)
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().response

        then:
        response.status == httpStatus

        where:
        cpf             | objResponse           | httpStatus
        "46356554070"   | Optional.of(student)  | 200
        "46356554070"   | Optional.empty()      | 404
    }

    @Unroll
    def "find all students"(){
        given:
        service.getAllStudents() >> listResponse

        when:
        def response = mockMvc.perform(get(path+"/all")
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().response

        then:
        response.status == httpStatus

        where:
        cpf             | listResponse           | httpStatus
        "46356554070"   | Arrays.asList(student) | 200
        "46356554070"   | []                     | 404
    }

    @Unroll
    def "find students by classId"(){
        given:
        service.getStudentsByClass(classId) >> listResponse

        when:
        def response = mockMvc.perform(get(path+"/class")
                .header("classId", classId)
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().response

        then:
        response.status == httpStatus

        where:
        classId    | listResponse            | httpStatus
        "AO1234"   | Arrays.asList(student)  | 200
        "B3R400"   | []                      | 404
    }

    @Unroll
    def "delete student register"(){
        given:
        service.delete(cpf)

        when:
        def response = mockMvc.perform(delete(path)
                .header("cpf", cpf)
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().response

        then:
        response.status == httpStatus

        where:
        cpf             | httpStatus
        "46356554070"   | 202
    }
}
