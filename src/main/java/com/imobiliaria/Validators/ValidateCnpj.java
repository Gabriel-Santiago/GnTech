package com.imobiliaria.Validators;

import com.imobiliaria.exceptions.CnpjClienteExistException;
import com.imobiliaria.exceptions.CnpjIsEmptyException;
import com.imobiliaria.exceptions.CnpjNotFoundException;
import com.imobiliaria.repositories.ImobiliariaRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidateCnpj {

    private final ImobiliariaRepository repository;

    public ValidateCnpj(ImobiliariaRepository repository) {
        this.repository = repository;
    }

    public void validate(String cnpj){
        if(cnpj == null){
            throw new CnpjNotFoundException();
        }

        if(cnpj.trim().isEmpty()){
            throw new CnpjIsEmptyException();
        }

        if (repository.existsByCnpj(cnpj)) {
            throw new CnpjClienteExistException();
        }
    }
}
