package com.imobiliaria.dto.response;

public record ImobiliariaResponseDTO(
        Long imobiliariaId,
        String email,
        String cnpj,
        String responsavel,
        String telefone,
        String cep,
        String rua,
        String bairro,
        String cidade,
        String estado,
        String numero
) {
}
