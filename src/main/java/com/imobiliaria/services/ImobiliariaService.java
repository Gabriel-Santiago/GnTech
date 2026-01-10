package com.imobiliaria.services;

import com.imobiliaria.Validators.ValidateCep;
import com.imobiliaria.Validators.ValidateCnpj;
import com.imobiliaria.Validators.ValidateId;
import com.imobiliaria.apis.DadosCnpj;
import com.imobiliaria.apis.ReceitaWsAPI;
import com.imobiliaria.dto.request.DeleteImobiliariaRequestDTO;
import com.imobiliaria.dto.request.ImobiliariaRequestDTO;
import com.imobiliaria.dto.request.UpdateEmailImobiliariaRequestDTO;
import com.imobiliaria.dto.request.UpdateTelefoneImobiliariaRequestDTO;
import com.imobiliaria.dto.response.ImobiliariaResponseDTO;
import com.imobiliaria.entities.Imobiliaria;
import com.imobiliaria.exceptions.SenhaImobiliariaIncorretException;
import com.imobiliaria.repositories.ImobiliariaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImobiliariaService {

    private final ImobiliariaRepository repository;
    private final ReceitaWsAPI receitaWsAPI;
    private final ValidateCep validateCep;
    private final ValidateCnpj validateCnpj;
    private final ValidateId  validateId;

    public ImobiliariaService(ImobiliariaRepository repository,
                              ReceitaWsAPI receitaWsAPI,
                              ValidateCep validateCep,
                              ValidateCnpj validateCnpj,
                              ValidateId validateId) {
        this.repository = repository;
        this.receitaWsAPI = receitaWsAPI;
        this.validateCep = validateCep;
        this.validateCnpj = validateCnpj;
        this.validateId = validateId;
    }

    @Transactional
    public void CreateImobiliaria(ImobiliariaRequestDTO dto) throws Exception {
        validateCnpj.validate(dto.cnpj());

        DadosCnpj dadosCnpj = receitaWsAPI
                .consultaCnpj(dto.cnpj());

        validateCep.validate(dadosCnpj.cep());

        Imobiliaria imobiliaria = new Imobiliaria();
        imobiliaria.setEmail(dto.email());
        imobiliaria.setSenha(dto.senha());
        imobiliaria.setResponsavel(dto.responsavel());
        imobiliaria.setTelefone(dto.telefone());

        imobiliaria.setCnpj(dto.cnpj());
        imobiliaria.setCep(dadosCnpj.cep());
        imobiliaria.setRua(dadosCnpj.logradouro());
        imobiliaria.setBairro(dadosCnpj.bairro());
        imobiliaria.setCidade(dadosCnpj.municipio());
        imobiliaria.setEstado(dadosCnpj.uf());
        imobiliaria.setNumero(dadosCnpj.numero());

        repository.save(imobiliaria);
    }

    public List<ImobiliariaResponseDTO> findAllImobiliaria() {
        return repository
                .findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Transactional
    public void updateEmail(UpdateEmailImobiliariaRequestDTO dto) {
        Imobiliaria imobiliaria = validateId
                .validate(dto.imobiliariaId(), repository);

        imobiliaria.setEmail(dto.email());
    }

    @Transactional
    public void updateTelefone(UpdateTelefoneImobiliariaRequestDTO dto) {
        Imobiliaria imobiliaria = validateId
                .validate(dto.imobiliariaId(), repository);

        imobiliaria.setTelefone(dto.telefone());
    }

    @Transactional
    public void deleteImobiliaria(DeleteImobiliariaRequestDTO dto) {
        Imobiliaria imobiliaria = validateId
                .validate(dto.imobiliariaId(), repository);

        if(!imobiliaria.getSenha().equals(dto.senha())){
            throw new SenhaImobiliariaIncorretException();
        }

        repository.delete(imobiliaria);
    }

    private ImobiliariaResponseDTO toDTO(Imobiliaria imobiliaria) {
        return new ImobiliariaResponseDTO(
                imobiliaria.getId(),
                imobiliaria.getEmail(),
                imobiliaria.getCnpj(),
                imobiliaria.getResponsavel(),
                imobiliaria.getTelefone(),
                imobiliaria.getCep(),
                imobiliaria.getRua(),
                imobiliaria.getBairro(),
                imobiliaria.getCidade(),
                imobiliaria.getEstado(),
                imobiliaria.getNumero()
        );
    }
}
