package com.DCLink.task.exception.handler;

import com.DCLink.task.exception.ExceptionObject;
import com.DCLink.task.exception.NotFoundException;
import com.DCLink.task.exception.TypeErrorException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = TypeErrorException.class)
    protected ResponseEntity<Object> handleTypeError(TypeErrorException ex, WebRequest request) {
        return handleExceptionInternal(ex, new ExceptionObject(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = NotFoundException.class)
    protected ResponseEntity<Object> handleTypeError(NotFoundException ex, WebRequest request) {
        return handleExceptionInternal(ex, new ExceptionObject(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage()), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}