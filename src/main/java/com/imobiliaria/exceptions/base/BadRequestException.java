package com.imobiliaria.exceptions.base;

public abstract class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
