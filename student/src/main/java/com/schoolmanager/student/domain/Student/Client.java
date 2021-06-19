package com.schoolmanager.student.domain.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private String cpf;
    private String name;
    private String email;
    private String birthdate;
    private List<Contacts> contactsList;
    private Address address;
}
