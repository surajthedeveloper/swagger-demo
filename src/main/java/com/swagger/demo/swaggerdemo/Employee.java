package com.swagger.demo.swaggerdemo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Employee {
    @ApiModelProperty(notes = "Unique employee ID")
    private String id;
    @ApiModelProperty(notes = "Employee name", required = true)
    private String name;
    @ApiModelProperty(notes = "Employee age")
    private int age;
    @ApiModelProperty(notes = "Employee salary")
    private double salary;
}
