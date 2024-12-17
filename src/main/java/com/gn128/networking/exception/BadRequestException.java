package com.gn128.networking.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends RuntimeException {

    private final String message;

    public BadRequestException(String message) {
        this.message = message;
    }
}
