package com.imobiliaria.dto.request;

import java.math.BigDecimal;

public record UpdateValorDiariaRequestDTO(
        Long imovelId,
        BigDecimal valorDiaria
) {
}
