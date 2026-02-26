package com.example.howgarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name = "estudiante_asignatura")
public class Nota {

    @EmbeddedId
    private EstudianteAsignatura idNota;

    @ManyToOne
    @MapsId("idEstudiante")
    @JoinColumn(name = "id_estudiante")
    @JsonBackReference("estudiante-nota")
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("idAsignatura")
    @JoinColumn(name = "id_asignatura")
    @JsonBackReference("asignatura-nota")
    private Asignatura asignatura;

    private Double calificacion;
}