package com.mycompany.property.management.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class ErrorModel {

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ErrorModel setCode(String code) {
        this.code = code;
        return this;
    }

    public ErrorModel setMessage(String message) {
        this.message = message;
        return this;
    }
}
