package com.swagger.demo.swaggerdemo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ErrorMessage {
    @ApiModelProperty(notes = "error message", required = true)
    private String message;
    @ApiModelProperty(notes = "error occurred time")
    private final LocalDateTime time = LocalDateTime.now();
}
