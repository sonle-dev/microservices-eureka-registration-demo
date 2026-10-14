package com.example.orderservice.exception;

import com.example.orderservice.dto.ApiResponseError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceUnavailableException.class)
    public ResponseEntity<ApiResponseError> handleServiceUnavailable(ServiceUnavailableException ex, HttpServletRequest request) {
        ApiResponseError errorResponse = new ApiResponseError(
                HttpStatus.SERVICE_UNAVAILABLE.value(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorResponse);
    }
}