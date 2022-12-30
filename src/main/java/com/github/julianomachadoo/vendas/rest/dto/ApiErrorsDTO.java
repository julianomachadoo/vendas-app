package com.github.julianomachadoo.vendas.rest.dto;

public class ApiErrorsDTO {

    private final String error;
    private String campo;

    public ApiErrorsDTO(String message) {
        this.error = message;
    }

    public ApiErrorsDTO(String error, String campo) {
        this.error = error;
        this.campo = campo;
    }

    public String getError() {
        return error;
    }

    public String getCampo() {
        return campo;
    }
}
