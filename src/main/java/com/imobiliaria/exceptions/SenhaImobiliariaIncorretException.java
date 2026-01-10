package com.imobiliaria.exceptions;

import com.imobiliaria.exceptions.base.UnauthorizedException;

public class SenhaImobiliariaIncorretException extends UnauthorizedException {
    public SenhaImobiliariaIncorretException() {
        super("A senha está incorreta!");
    }
}
