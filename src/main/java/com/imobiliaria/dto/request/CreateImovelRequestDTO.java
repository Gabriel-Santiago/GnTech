package com.imobiliaria.dto.request;

import com.imobiliaria.enums.TipoImovel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateImovelRequestDTO(
        Long imobiliariaId,
        String cep,
        String numero,
        boolean alugado,
        LocalDateTime dataCheckIn,
        LocalDateTime dataCheckOut,
        BigDecimal valorDiaria,
        TipoImovel tipoImovel
) {
}
