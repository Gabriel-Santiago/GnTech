package com.imobiliaria.exceptions.base;

public abstract class ConflictException extends RuntimeException{
    public ConflictException(String message) {
        super(message);
    }
}
