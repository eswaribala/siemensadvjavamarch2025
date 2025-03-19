package com.siemens.customerapi.exceptions;

import com.siemens.customerapi.dtos.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerGlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<GenericResponse> handleCustomerNotFoundException
            (CustomerNotFoundException customerNotFoundException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new GenericResponse(customerNotFoundException.getMessage()));
    }


}
