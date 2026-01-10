package com.imobiliaria.dto.response;

import com.imobiliaria.enums.TipoImovel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ImovelResponseDTO(
        Long imobiliariaId,
        Long imovelId,
        boolean alugado,
        LocalDateTime dataCheckIn,
        LocalDateTime dataCheckOut,
        Integer diasRestanteHospedagem,
        BigDecimal valorDiaria,
        TipoImovel tipoImovel,
        String cep,
        String rua,
        String bairro,
        String cidade,
        String estado,
        String numero
) {
}
