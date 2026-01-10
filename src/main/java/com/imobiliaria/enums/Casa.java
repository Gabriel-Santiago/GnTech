package com.imobiliaria.enums;

import lombok.Getter;

@Getter
public enum Casa {

    TERREA("Térrea"),
    GERMINADA("Germinada"),
    SOBRADO("Sobrado"),
    EDICULA("Edícula");

    private final String descricao;

    Casa(String descricao){
        this.descricao = descricao;
    }
}
