package com.example.ticketservice.handler;

import com.example.ticketservice.exception.ErrorResponseArray;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseArray> handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<String> errors = new ArrayList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }

        ErrorResponseArray errorResponse = new ErrorResponseArray();
        errorResponse.setTitle("Ошибка валидации");
        errorResponse.setDetails(errors);

        // Получение динамического URL
        errorResponse.setInstance(request.getRequestURI()); // Если нужен только URI
        // errorResponse.setInstance(request.getRequestURL().toString()); // Если нужен полный URL

        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
