package com.imobiliaria.entities;

import com.imobiliaria.enums.Apartamento;
import com.imobiliaria.enums.Casa;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "imovel")
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class Imovel extends BaseEntity {

    private boolean alugado;
    private LocalDateTime dataCheckIn;
    private LocalDateTime dataCheckOut;
    private Integer diasRestanteHospedagem;
    private BigDecimal valorDiaria;

    @Enumerated(EnumType.STRING)
    private Apartamento apartamento;

    @Enumerated(EnumType.STRING)
    private Casa casa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "imobiliariaId")
    private Imobiliaria imobiliaria;
}
