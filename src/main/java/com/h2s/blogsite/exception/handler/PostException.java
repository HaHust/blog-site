package com.h2s.blogsite.exception.handler;

import com.h2s.blogsite.dto.response.MessageResponse;
import com.h2s.blogsite.exception.UserNotExistException;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PostException {

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<String> handleExceptionA(Exception e) {
        return ResponseEntity.status(Response.SC_NOT_FOUND).body(e.getMessage());
    }
}
