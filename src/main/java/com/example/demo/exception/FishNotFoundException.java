package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FishNotFoundException extends RuntimeException {

    public FishNotFoundException(Long id) {

        super("Fish not found: " + id);
    }
}