package com.imobiliaria.exceptions;

import com.imobiliaria.exceptions.base.NotFoundException;

public class IdNotFoundException extends NotFoundException {
    public IdNotFoundException(){
        super("ID não foi encontrado!");
    }
}
