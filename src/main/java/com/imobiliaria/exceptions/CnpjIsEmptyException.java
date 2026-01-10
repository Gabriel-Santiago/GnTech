package com.imobiliaria.exceptions;

import com.imobiliaria.exceptions.base.BadRequestException;

public class CnpjIsEmptyException extends BadRequestException {
    public CnpjIsEmptyException() {
        super("CNPJ não pode estar vazio!");
    }
}
