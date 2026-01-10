package com.imobiliaria.repositories;

import com.imobiliaria.entities.Imovel;
import com.imobiliaria.enums.Apartamento;
import com.imobiliaria.enums.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel,Integer> {

    boolean existsByCnpj(String cnpj);

    List<Imovel> findByImobiliariaId(Long imobiliariaId);

    List<Imovel> findByApartamento(Apartamento apartamento);

    List<Imovel> findByCasa(Casa casa);

    List<Imovel> findByBairro(String bairro);

    List<Imovel> findByCidade(String cidade);

    List<Imovel> findByEstado(String estado);
}
