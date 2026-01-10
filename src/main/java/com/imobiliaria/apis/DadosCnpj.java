package com.imobiliaria.apis;

public record DadosCnpj(
        String cep,
        String logradouro,
        String bairro,
        String municipio,
        String uf,
        String numero,
        String telefone
) {
}
