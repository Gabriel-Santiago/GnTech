package com.imobiliaria.dto.response;

public record ErrorResponseDTO(
        boolean success,
        String message
) {
}
