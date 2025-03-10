package com.project.clothing_store_backend.adviser;

import com.project.clothing_store_backend.exception.DuplicateEntryException;
import com.project.clothing_store_backend.exception.EntryNotFoundException;
import com.project.clothing_store_backend.exception.UnauthorizedException;
import com.project.clothing_store_backend.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<StandardResponse> handleUnauthorizedException(UnauthorizedException e){
        return new ResponseEntity<>(
                StandardResponse.builder()
                        .code(401)
                        .message(e.getMessage())
                        .data(null)
                        .build(),
                HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandardResponse> handleEntryNotFoundException(EntryNotFoundException e){
        return new ResponseEntity<>(
                StandardResponse.builder()
                        .code(404)
                        .message(e.getMessage())
                        .data(null)
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<StandardResponse> handleDuplicateEntryException(DuplicateEntryException e){
        return new ResponseEntity<>(
                StandardResponse.builder()
                        .code(409)
                        .message(e.getMessage())
                        .data(null)
                        .build(),
                HttpStatus.CONFLICT
        );
    }
}
