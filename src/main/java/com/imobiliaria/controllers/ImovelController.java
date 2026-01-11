package com.imobiliaria.controllers;

import com.imobiliaria.dto.request.CreateImovelRequestDTO;
import com.imobiliaria.dto.request.DeleteImovelRequestDTO;
import com.imobiliaria.dto.request.UpdateValorDiariaRequestDTO;
import com.imobiliaria.dto.response.ImovelResponseDTO;
import com.imobiliaria.enums.TipoImovel;
import com.imobiliaria.services.ImovelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/imovel")
@RestController
public class ImovelController {

    private final ImovelService imovelService;

    public ImovelController(ImovelService imovelService) {
        this.imovelService = imovelService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Void> createImovel(@RequestBody CreateImovelRequestDTO dto) throws Exception {
        imovelService.createImovel(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ImovelResponseDTO>> findAll() {
        return new ResponseEntity<>(imovelService.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/imobiliaria/{imobiliariaId}")
    public ResponseEntity<List<ImovelResponseDTO>> findByImobiliaria(@PathVariable Long imobiliariaId) {
        return new ResponseEntity<>(imovelService.findByImobiliaria(imobiliariaId),
                HttpStatus.OK
        );
    }

    @GetMapping("/tipo")
    public ResponseEntity<List<ImovelResponseDTO>> findByTipoImovel(@RequestParam TipoImovel tipoImovel) {
        return new ResponseEntity<>(imovelService.findByTipoImovel(tipoImovel),
                HttpStatus.OK
        );
    }

    @GetMapping("/bairro")
    public ResponseEntity<List<ImovelResponseDTO>> findByBairro(@RequestParam String bairro) {
        return new ResponseEntity<>(imovelService.findByBairro(bairro),
                HttpStatus.OK
        );
    }

    @GetMapping("/cidade")
    public ResponseEntity<List<ImovelResponseDTO>> findByCidade(@RequestParam String cidade) {
        return new ResponseEntity<>(imovelService.findByCidade(cidade),
                HttpStatus.OK
        );
    }

    @GetMapping("/estado")
    public ResponseEntity<List<ImovelResponseDTO>> findByEstado(@RequestParam String estado) {
        return new ResponseEntity<>(imovelService.findByEstado(estado),
                HttpStatus.OK
        );
    }

    @PatchMapping("/valor-diaria")
    public ResponseEntity<Void> updateValorDiaria(@RequestBody UpdateValorDiariaRequestDTO dto) {
        imovelService.updateValorDiaria(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteImovel(@RequestBody DeleteImovelRequestDTO dto) {
        imovelService.deleteImovel(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
