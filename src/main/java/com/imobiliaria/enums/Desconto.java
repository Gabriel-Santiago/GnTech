package com.imobiliaria.enums;

import lombok.Getter;

@Getter
public enum Desconto {

    PORCENTAGEM("Porcentagem"),
    VALOR("Valor"),
    NENHUM("Nenhum");

    private final String descricao;

    Desconto(String descricao){
        this.descricao = descricao;
    }
}
