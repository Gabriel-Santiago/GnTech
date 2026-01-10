package com.imobiliaria.Validators;

import com.imobiliaria.exceptions.IdNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidateId {

    public <T, ID> T validate(ID id, JpaRepository<T, ID> repository) {
        return repository.findById(id)
                .orElseThrow(IdNotFoundException::new);
    }
}
