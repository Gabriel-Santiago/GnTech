package com.imobiliaria.exceptions;

import com.imobiliaria.exceptions.base.NotFoundException;

public class CepNotFoundException extends NotFoundException {

    public CepNotFoundException() {
        super("Cep não foi encontrado!");
    }
}
