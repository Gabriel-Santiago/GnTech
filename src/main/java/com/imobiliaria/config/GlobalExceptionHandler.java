package com.imobiliaria.config;

import com.imobiliaria.dto.response.ErrorResponseDTO;
import com.imobiliaria.exceptions.base.BadRequestException;
import com.imobiliaria.exceptions.base.ConflictException;
import com.imobiliaria.exceptions.base.NotFoundException;
import com.imobiliaria.exceptions.base.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFound(NotFoundException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                false,
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDTO> handleBadRequest(BadRequestException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                false,
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponseDTO> handleConflict(ConflictException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                false,
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponseDTO> handleUnauthorized(UnauthorizedException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                false,
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
}
