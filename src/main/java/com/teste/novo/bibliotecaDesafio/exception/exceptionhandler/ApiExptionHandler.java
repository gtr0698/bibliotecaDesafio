package com.teste.novo.bibliotecaDesafio.exception.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public class ApiExptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionDto handler(MethodArgumentNotValidException ex){

        ExceptionDto exceptionDto = new ExceptionDto("Um ou mais campos estão invalidos!");

        List<FieldError> fieldErros = ex.getBindingResult().getFieldErrors();

        for(FieldError fieldError : fieldErros){
            String nome = fieldError.getField();
            String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());

            exceptionDto.adicionaCampoComErro(nome, mensagem);
        }

        return exceptionDto;
    }
}
