package com.innowise.darya.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "There is no such element")
    @ExceptionHandler(ThereIsNoSuchException.class)
    protected String handleThereIsNoSuchBookException(ThereIsNoSuchException exception) {

        return "There is no such " + exception.getFieldName();
    }
}
