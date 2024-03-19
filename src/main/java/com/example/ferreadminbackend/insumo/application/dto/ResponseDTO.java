package com.example.ferreadminbackend.insumo.application.dto;

import java.util.List;

public class ResponseDTO <T> {
    private String identificador;
    private String codError;
    private String msjError;
    List<T> object;

    public ResponseDTO() {
    }

    public ResponseDTO(String identificador, String codError, String msjError, List<T> object) {
        this.codError = codError;
        this.identificador = identificador;
        this.msjError = msjError;
        this.object = object;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getCodError() {
        return this.codError;
    }

    public void setCodError(String codError) {
        this.codError = codError;
    }

    public String getMsjError() {
        return this.msjError;
    }

    public void setMsjError(String msjError) {
        this.msjError = msjError;
    }

    public List<T> getObject() {
        return this.object;
    }

    public void setObject(List<T> object) {
        this.object = object;
    }
}
