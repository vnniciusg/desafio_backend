package com.desafiobackend.application.exceptions;

import com.desafiobackend.dto.ExceptionsDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity handleDuplicateEntry(DataIntegrityViolationException exception){
        ExceptionsDTO exceptionDTO = new ExceptionsDTO("Usuário já cadastrado", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionsDTO> handleNotFoundException(EntityNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionsDTO> handleGeneralException(Exception exception) {
        ExceptionsDTO exceptionsDTO = new ExceptionsDTO(exception.getMessage(), "500");
        return ResponseEntity.internalServerError().body(exceptionsDTO);
    }
}
