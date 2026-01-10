package com.imobiliaria.Validators;

import com.imobiliaria.exceptions.CepIsEmptyException;
import com.imobiliaria.exceptions.CepNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ValidateCep {

    public void validate(String cep){
        if(cep == null){
            throw new CepNotFoundException();
        }

        if(cep.trim().isEmpty()){
            throw new CepIsEmptyException();
        }
    }
}
