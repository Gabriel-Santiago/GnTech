package com.imobiliaria.enums;

import lombok.Getter;

@Getter
public enum Apartamento {

    PADRAO("Padrão"),
    STUDIO_KITNET("Studio/Kitnet"),
    DUPLEX("Duplex"),
    TRIPLEX("Triplex"),
    COBERTURA("Cobertura"),
    LOFT("Loft");

    private final String descricao;

    Apartamento(String descricao){
        this.descricao = descricao;
    }
}
