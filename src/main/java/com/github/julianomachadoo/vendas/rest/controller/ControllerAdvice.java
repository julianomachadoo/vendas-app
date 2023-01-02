package com.github.julianomachadoo.vendas.rest.controller;

import com.github.julianomachadoo.vendas.exceptions.DadosInvalidosException;
import com.github.julianomachadoo.vendas.exceptions.DadosNaoEncontradosException;
import com.github.julianomachadoo.vendas.rest.dto.ApiErrorsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @Autowired
    MessageSource messageSource;

    @ExceptionHandler(DadosNaoEncontradosException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorsDTO handleDadosNaoEncontradosException(DadosNaoEncontradosException ex) {
        return new ApiErrorsDTO(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ApiErrorsDTO> handleValidacoes(MethodArgumentNotValidException ex) {
        List<ApiErrorsDTO> dtoList = new ArrayList<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ApiErrorsDTO erro = new ApiErrorsDTO(e.getField(), mensagem);
            dtoList.add(erro);
        });
        return dtoList;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorsDTO handleDataIntegrityViolationException() {
        return new ApiErrorsDTO("Não foi possível realizar operação, algum campo que deve ser único está sendo enviado de forma repetida");
    }

    @ExceptionHandler(DadosInvalidosException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorsDTO handleDadosInvalidosException(DadosInvalidosException ex) {
        return new ApiErrorsDTO(ex.getMessage());
    }
}
