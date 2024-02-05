package com.api.crechau.exceptions;

import com.api.crechau.utils.ApiGlobalResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<ApiGlobalResponseDto> resourceNotFoundExceptionHandler(ResourceNotFoundException exception){
        Map<String, String> error = Map.of("error", exception.getMessage());
        var response = new ApiGlobalResponseDto(error);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
