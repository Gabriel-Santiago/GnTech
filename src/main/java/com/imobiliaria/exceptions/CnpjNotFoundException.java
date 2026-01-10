package com.imobiliaria.exceptions;

import com.imobiliaria.exceptions.base.NotFoundException;

public class CnpjNotFoundException extends NotFoundException {
    public CnpjNotFoundException(){
        super("CNPJ não foi encontrado!");
    }
}
