package com.schoolmanager.student.domain.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contacts {
    private String telephone;

    private void validateTelephoneFormat(){

        String phone_regex = "\\(?\\d{2,}\\)?[ -]?\\d{4,}[\\-\\s]?\\d{4}";
        Pattern patternPhone = Pattern.compile(phone_regex);
        Matcher matcherPhone = patternPhone.matcher(this.telephone);
       log.info(matcherPhone.toString());
    }
}
