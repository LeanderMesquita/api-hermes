package com.llm.hermes.core.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<MappedError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        MappedError error = new MappedError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Not founded", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
