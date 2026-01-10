package com.imobiliaria.apis;

public record EnderecoCep(
        String logradouro,
        String bairro,
        String localidade,
        String uf
) {
}
