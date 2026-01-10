package com.imobiliaria.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "imobiliaria")
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class Imobiliaria extends BaseEntity {

    private String email;
    private String senha;

    private String cnpj;
    private String responsavel;
    private String telefone;

    @OneToMany(mappedBy = "imobiliaria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Imovel> imovelList;
}
