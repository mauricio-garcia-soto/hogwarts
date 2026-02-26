package com.example.howgarts.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class EstudianteAsignaturaId implements Serializable {
    private Long idEstudiante;
    private Long idAsignatura;
}
