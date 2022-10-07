package com.swagger.demo.swaggerdemo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Employee Controller", description = "Employee Controller")
public class APIController {

    private final List<Employee> employeeList = new ArrayList<>();

    @PostMapping(value = "/employee",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Employee", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Employee record created")
    })
    public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee) {
        employee.setId(UUID.randomUUID().toString());
        employeeList.add(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping(value = "/employee/{employeeId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find Employee by Id", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Employee record found"),
            @ApiResponse(code = 404, message = "Employee record not found")
    })
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("employeeId") String employeeId) throws EmployeeNotFoundException {
        final Employee employee = employeeList.stream().filter(emp -> emp.getId().equals(employeeId)).findFirst().orElseThrow(
                () -> new EmployeeNotFoundException(employeeId)
        );
        return ResponseEntity.ok(employee);
    }

}
