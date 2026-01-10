package com.imobiliaria.repositories;

import com.imobiliaria.entities.Imobiliaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImobiliariaRepository extends JpaRepository<Imobiliaria,Long> {

    boolean existsByCnpj(String cnpj);
}
