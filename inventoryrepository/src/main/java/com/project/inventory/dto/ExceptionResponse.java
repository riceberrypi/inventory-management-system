package com.project.inventory.dto;

import java.io.Serializable;

public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;

    public ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
