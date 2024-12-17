package com.gn128.networking.exception;

import com.gn128.networking.payload.ModuleResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ModuleResponse handleBadRequestException(BadRequestException badRequestException) {
        return ModuleResponse.builder().message(badRequestException.getMessage()).build();
    }
}
