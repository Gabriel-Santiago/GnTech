package com.imobiliaria.repositories;

import com.imobiliaria.entities.Imovel;
import com.imobiliaria.enums.TipoImovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel,Long> {

    boolean existsByCnpj(String cnpj);

    List<Imovel> findByImobiliariaId(Long imobiliariaId);

    List<Imovel> findByTipoImovel(TipoImovel tipoImovel);

    List<Imovel> findByBairro(String bairro);

    List<Imovel> findByCidade(String cidade);

    List<Imovel> findByEstado(String estado);
}
