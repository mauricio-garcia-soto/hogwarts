package com.example.howgarts.dto;

import java.util.List;

public class CasaDto {
    private Long id;
    private String nombre;
    private String fundador;
    private String fantasma;
    private ProfesorDto jefe;
    private List<String> estudiantes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFundador() {
        return fundador;
    }

    public void setFundador(String fundador) {
        this.fundador = fundador;
    }

    public String getFantasma() {
        return fantasma;
    }

    public void setFantasma(String fantasma) {
        this.fantasma = fantasma;
    }

    public ProfesorDto getJefe() {
        return jefe;
    }

    public void setJefe(ProfesorDto jefe) {
        this.jefe = jefe;
    }

    public List<String> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<String> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
