package com.imobiliaria.controllers;

import com.imobiliaria.dto.request.DeleteImobiliariaRequestDTO;
import com.imobiliaria.dto.request.ImobiliariaRequestDTO;
import com.imobiliaria.dto.request.UpdateEmailImobiliariaRequestDTO;
import com.imobiliaria.dto.request.UpdateTelefoneImobiliariaRequestDTO;
import com.imobiliaria.dto.response.ImobiliariaResponseDTO;
import com.imobiliaria.services.ImobiliariaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/imobiliaria")
@RestController
public class ImobiliariaController {

    private final ImobiliariaService imobiliariaService;

    public ImobiliariaController(ImobiliariaService imobiliariaService) {
        this.imobiliariaService = imobiliariaService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Void> createImobiliaria(@RequestBody ImobiliariaRequestDTO dto) throws Exception {
        imobiliariaService.CreateImobiliaria(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ImobiliariaResponseDTO>> findAllImobiliarias() {
        return new ResponseEntity<>(imobiliariaService.findAllImobiliaria(),
                HttpStatus.OK);
    }

    @PatchMapping("/email")
    public ResponseEntity<Void> updateEmail(@RequestBody UpdateEmailImobiliariaRequestDTO dto) {
        imobiliariaService.updateEmail(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/telefone")
    public ResponseEntity<Void> updateTelefone(@RequestBody UpdateTelefoneImobiliariaRequestDTO dto) {
        imobiliariaService.updateTelefone(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteImobiliaria(@RequestBody DeleteImobiliariaRequestDTO dto) {
        imobiliariaService.deleteImobiliaria(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
