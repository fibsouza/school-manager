package com.schoolmanager.student.application

import com.schoolmanager.student.domain.Student.Address
import com.schoolmanager.student.domain.Student.Contact
import com.schoolmanager.student.domain.Student.Student
import com.schoolmanager.student.repository.StudentRepository
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class StudentServiceTest extends  Specification{
    def repository = Mock(StudentRepository)
    def service = new StudentService(repository)

    @Shared
    def student = Student.builder()
            .studentId(UUID.randomUUID().toString())
            .cpf("46356554070")
            .name("Luiz Alberto Gregório")
            .email("greg@yahoo.com.br")
            .birthdate("12/04/1990")
            .contactList(
                    Arrays.asList(
                            Contact.builder().telephone("").build(),
                            Contact.builder().telephone("2121").build())
            )
            .address(new Address("Avenida das Américas 1.223", "Rio de Janeiro", "Brasil", "23456098"))
            .build()

    @Unroll
    def "create new student"(){
        given:
        repository.findStudentByCpf(_) >> Optional.empty()
        repository.save(_) >> student
        when:
        def response = service.create(student)
        then:
        assert response.studentId != null
        assert response.cpf == student.getCpf()
    }

    @Unroll
    def "create new student [not created]"(){
        given:
        repository.findStudentByCpf(_) >> Optional.of(student)
        when:
        def response = service.create(student)
        then:
        assert response == null
    }

    @Unroll
    def "update student register"(){
        given:
        def cpf = "46356554070"
        repository.findStudentByCpf(_) >> Optional.of(Student)
        repository.save(_) >> student
        when:
        def response = service.update(cpf, student)
        then:
        assert response.studentId != null
        assert response.cpf == student.getCpf()
    }

    @Unroll
    def "update student register [not update]"(){
        given:
        def cpf = "46356554070"
        repository.findStudentByCpf(_) >> Optional.empty()
        when:
        def response = service.update(cpf, student)
        then:
        assert response == null
    }

    @Unroll
    def "get student by cpf"(){
        given:
        def cpf = "46356554070"
        repository.findStudentByCpf(_) >> Optional.of(Student)
        when:
        def response = service.getStudentById(cpf)
        then:
        response.isPresent()
    }

    @Unroll
    def "get all students"(){
        given:
        repository.findAll(_) >> new ArrayList()
        when:
        def response = service.findAll()
        then:
        response instanceof List<Student>
    }

    @Unroll
    def "get students by classId"(){
        given:
        def classId = "ABC00789"
        repository.findStudentByClassId(_) >> new ArrayList<Student>()
        when:
        def response = service.getStudentsByClass(classId)
        then:
        response.size() >= 0
    }

    def "delete student register"(){
        given:
        repository.findStudentByCpf(_) >> Optional.of(student)
        expect:
        service.delete("46356554070")
    }
}
