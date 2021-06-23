package com.schoolmanager.student.infraestructure.error;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.*;

public class ApiErrorMessage {

    @JsonProperty("timestamp")
    protected LocalDateTime timestamp;

    @JsonProperty("code")
    protected String code;

    @JsonProperty("errors")
    protected List<Object> errors = new ArrayList<>();

    public ApiErrorMessage() { }

    public LocalDateTime getTimestamp() {
        return LocalDateTime.now();
    }
}
