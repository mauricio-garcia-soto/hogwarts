package com.example.howgarts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class EstudianteAsignatura  implements Serializable {
    @Column(name = "id_estudiante")
    Long idEstudiante;

    @Column(name = "id_asignatura")
    Long idAsignatura;
}
