package com.swagger.demo.swaggerdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmployeeNotFoundException extends RuntimeException {
    private final String employeeId;
}
