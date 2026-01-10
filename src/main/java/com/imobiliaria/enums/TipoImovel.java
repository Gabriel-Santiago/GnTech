package com.imobiliaria.enums;

import lombok.Getter;

@Getter
public enum TipoImovel {

    PADRAO(CategoriaImovel.APARTAMENTO, "Padrão"),
    STUDIO_KITNET(CategoriaImovel.APARTAMENTO, "Studio/Kitnet"),
    DUPLEX(CategoriaImovel.APARTAMENTO, "Duplex"),
    TRIPLEX(CategoriaImovel.APARTAMENTO, "Triplex"),
    COBERTURA(CategoriaImovel.APARTAMENTO, "Cobertura"),
    LOFT(CategoriaImovel.APARTAMENTO, "Loft"),

    TERREA(CategoriaImovel.CASA, "Térrea"),
    GERMINADA(CategoriaImovel.CASA, "Germinada"),
    SOBRADO(CategoriaImovel.CASA, "Sobrado"),
    EDICULA(CategoriaImovel.CASA, "Edícula");

    private final CategoriaImovel categoria;
    private final String descricao;

    TipoImovel(CategoriaImovel categoria, String descricao) {
        this.categoria = categoria;
        this.descricao = descricao;
    }
}

