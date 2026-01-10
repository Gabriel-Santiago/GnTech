package com.imobiliaria.exceptions;

import com.imobiliaria.exceptions.base.ConflictException;

public class CnpjClienteExistException extends ConflictException {

    public CnpjClienteExistException() {
        super("CNPJ existente");
    }
}
