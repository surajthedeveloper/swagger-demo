package com.swagger.demo.swaggerdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class SwaggerDemoExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> resourceNotRegisteredException(final EmployeeNotFoundException ex, final WebRequest web) {
        return new ResponseEntity<>(ErrorMessage.builder()
                .message("Employee with ID " + ex.getEmployeeId() + " Not exist").build(), HttpStatus.NOT_FOUND);
    }

}
