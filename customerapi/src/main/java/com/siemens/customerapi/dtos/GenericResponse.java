package com.siemens.customerapi.dtos;

import lombok.Data;

@Data
public class GenericResponse<T> {
    private T data;
    private String message;
    public GenericResponse(T data) {
        this.data = data;
    }
    public GenericResponse(String message) {
        this.message = message;
    }
}
