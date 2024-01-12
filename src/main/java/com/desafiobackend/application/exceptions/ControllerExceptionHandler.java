package com.desafiobackend.application.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException (ResourceNotFoundException resourceNotFoundException, WebRequest request){
        return new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                resourceNotFoundException.getMessage(),
                request.getDescription(false));

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage globalExceptionHandler(Exception exception , WebRequest request){
        return new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                exception.getMessage(),
                request.getDescription(false)
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage globalDuplicateEntry(DataIntegrityViolationException dataIntegrityViolationException , WebRequest request){
        return new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                "Usuário já cadastrado",
                request.getDescription(false)
        );
    }


}
