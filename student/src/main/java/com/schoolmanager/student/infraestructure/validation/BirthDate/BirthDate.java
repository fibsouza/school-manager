package com.schoolmanager.student.infraestructure.validation.BirthDate;

import com.schoolmanager.student.infraestructure.validation.Telephone.TelephoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy= BirthDateValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BirthDate {

    String message() default "Invalid bithdate format. Please digit using this format: dd/MM/YYYY ";
    Class[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
