package com.example.howgarts.dto;

import lombok.Data;

@Data
public class NotaDto {
    private Long idEstudiante;
    private Long idAsignatura;
    private String nombreAsignatura;
    private Double calificacion;
}