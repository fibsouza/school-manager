package com.schoolmanager.student.domain.Student;

import com.schoolmanager.student.infraestructure.validation.BirthDate.BirthDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @NotEmpty
    private String cpf;
    @NotEmpty
    private String name;

    @NotEmpty
    @Email
    private String email;

    @Valid
    @BirthDate
    @NotEmpty
    private String birthdate;

    @Valid
    @NotEmpty
    private List<Contact> contactList;

    @NotNull
    private Address address;
}
