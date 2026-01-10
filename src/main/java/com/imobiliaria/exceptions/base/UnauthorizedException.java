package com.imobiliaria.exceptions.base;

public abstract class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(String message) {
        super(message);
    }
}
