package com.imobiliaria.dto.request;

public record ImobiliariaRequestDTO(
    String cnpj,
    String email,
    String senha,
    String responsavel,
    String telefone
) {
}
