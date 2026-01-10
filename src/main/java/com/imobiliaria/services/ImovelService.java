package com.imobiliaria.services;

import com.imobiliaria.Validators.ValidateCep;
import com.imobiliaria.Validators.ValidateId;
import com.imobiliaria.apis.EnderecoCep;
import com.imobiliaria.apis.ViaCepAPI;
import com.imobiliaria.dto.request.CreateImovelRequestDTO;
import com.imobiliaria.dto.request.DeleteImovelRequestDTO;
import com.imobiliaria.dto.request.UpdateValorDiariaRequestDTO;
import com.imobiliaria.dto.response.ImovelResponseDTO;
import com.imobiliaria.entities.Imobiliaria;
import com.imobiliaria.entities.Imovel;
import com.imobiliaria.enums.TipoImovel;
import com.imobiliaria.exceptions.ImobiliariaNotFoundException;
import com.imobiliaria.exceptions.SenhaImobiliariaIncorretException;
import com.imobiliaria.repositories.ImobiliariaRepository;
import com.imobiliaria.repositories.ImovelRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ImovelService {

    private final ImobiliariaRepository imobiliariaRepository;
    private final ImovelRepository repository;
    private final ViaCepAPI viaCepAPI;
    private final ValidateCep validateCep;
    private final ValidateId validateId;

    public ImovelService(ImobiliariaRepository imobiliariaRepository,
                         ImovelRepository repository,
                         ViaCepAPI viaCepAPI,
                         ValidateCep validateCep,
                         ValidateId validateId) {
        this.imobiliariaRepository = imobiliariaRepository;
        this.repository = repository;
        this.viaCepAPI = viaCepAPI;
        this.validateCep = validateCep;
        this.validateId = validateId;
    }

    @Transactional
    public void createImovel(CreateImovelRequestDTO dto) throws Exception {
        Imobiliaria imobiliaria = imobiliariaRepository
                .findById(dto.imobiliariaId())
                .orElseThrow(ImobiliariaNotFoundException::new);

        validateCep.validate(dto.cep());

        EnderecoCep enderecoCep = viaCepAPI.consultaCep(dto.cep());

        Imovel imovel = new Imovel();

        imovel.setCep(dto.cep());
        imovel.setRua(enderecoCep.logradouro());
        imovel.setBairro(enderecoCep.bairro());
        imovel.setCidade(enderecoCep.localidade());
        imovel.setEstado(enderecoCep.uf());
        imovel.setNumero(dto.numero());
        imovel.setImobiliaria(imobiliaria);

        imovel.setAlugado(dto.alugado());
        imovel.setDataCheckIn(null);
        imovel.setDataCheckOut(null);
        imovel.setDiasRestanteHospedagem(null);

        if (dto.alugado()){
            LocalDateTime checkIn = dto.dataCheckIn();
            LocalDateTime checkOut = dto.dataCheckOut();

            imovel.setDataCheckIn(checkIn);
            imovel.setDataCheckOut(checkOut);

            long diasRestantes = ChronoUnit.DAYS.between(
                    LocalDate.now(),
                    checkOut.toLocalDate()
            );

            imovel.setDiasRestanteHospedagem((int) Math.max(diasRestantes, 0));
        }

        imovel.setValorDiaria(dto.valorDiaria());
        imovel.setTipoImovel(dto.tipoImovel());


        repository.save(imovel);
    }

    List<ImovelResponseDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    List<ImovelResponseDTO> findByImobiliaria(Long imobiliariaId) {
        return repository
                .findByImobiliariaId(imobiliariaId)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    List<ImovelResponseDTO> findByTipoImovel(TipoImovel tipoImovel) {
        return repository
                .findByTipoImovel(tipoImovel)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    List<ImovelResponseDTO> findByBairro(String bairro) {
        return repository
                .findByBairro(bairro)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    List<ImovelResponseDTO> findByCidade(String cidade) {
        return repository
                .findByCidade(cidade)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    List<ImovelResponseDTO> findByEstado(String estado) {
        return repository
                .findByEstado(estado)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Transactional
    public void updateValorDiaria(UpdateValorDiariaRequestDTO dto) {
        Imovel imovel = validateId
                .validate(dto.imovelId(), repository);

        imovel.setValorDiaria(dto.valorDiaria());
    }

    @Transactional
    public void deleteImovel(DeleteImovelRequestDTO dto){
        Imovel imovel = validateId
                .validate(dto.imovelId(), repository);

        if(!imovel.getImobiliaria().getSenha().equals(dto.senha())){
            throw new SenhaImobiliariaIncorretException();
        }

        repository.delete(imovel);
    }

    private ImovelResponseDTO toDTO(Imovel imovel) {
        return new ImovelResponseDTO(
                imovel.getImobiliaria().getId(),
                imovel.getId(),
                imovel.isAlugado(),
                imovel.getDataCheckIn(),
                imovel.getDataCheckOut(),
                imovel.getDiasRestanteHospedagem(),
                imovel.getValorDiaria(),
                imovel.getTipoImovel(),
                imovel.getCep(),
                imovel.getRua(),
                imovel.getBairro(),
                imovel.getCidade(),
                imovel.getEstado(),
                imovel.getNumero()
        );
    }
}
