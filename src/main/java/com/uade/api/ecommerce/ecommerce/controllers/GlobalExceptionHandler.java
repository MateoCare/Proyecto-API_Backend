package com.uade.api.ecommerce.ecommerce.controllers;

import com.uade.api.ecommerce.ecommerce.dto.ErrorDTO;
import com.uade.api.ecommerce.ecommerce.dto.PageDTO;
import com.uade.api.ecommerce.ecommerce.exceptions.*;
import jakarta.servlet.ServletException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<?> resourceNotFound(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> validationException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PaginaFueraDelLimiteException.class)
    public ResponseEntity<?> paginacionException(Exception ex, WebRequest request) {
        PageDTO<?> pageDTO = ((PaginaFueraDelLimiteException) ex).getPageDTO();
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage(), pageDTO), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CamposVaciosException.class)
    public ResponseEntity<?> camposVaciosExceptioon(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    // Handle all other exceptions globally
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        String errorMessage = "An unexpected error occurred: " + ex.getMessage();
        return new ResponseEntity<>(new ErrorDTO(errorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}