package com.imobiliaria.exceptions;

import com.imobiliaria.exceptions.base.BadRequestException;

public class CepIsEmptyException extends BadRequestException {
    public CepIsEmptyException() {
        super("Cep está vazio!");
    }
}
