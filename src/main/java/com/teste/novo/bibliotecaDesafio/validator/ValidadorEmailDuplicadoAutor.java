package com.teste.novo.bibliotecaDesafio.validator;

import com.teste.novo.bibliotecaDesafio.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidadorEmailDuplicadoAutor implements ConstraintValidator<VerificaEmailDuplicadoAutor, String> {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){

        return this.autorRepository.findByEmail(value).isPresent();
    }
}
