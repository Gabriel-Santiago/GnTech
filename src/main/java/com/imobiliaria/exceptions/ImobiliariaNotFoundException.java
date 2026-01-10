package com.imobiliaria.exceptions;

import com.imobiliaria.exceptions.base.NotFoundException;

public class ImobiliariaNotFoundException extends NotFoundException {
    public ImobiliariaNotFoundException() {
        super("Imobiliaria não foi encontrada!");
    }
}
