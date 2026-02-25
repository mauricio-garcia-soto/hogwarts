package com.example.howgarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "asignatura_calificacion")
public class Nota {


    @ManyToOne
    @MapsId("idEstudiante")
    @JoinColumn(name = "id_estudiante")
    @JsonBackReference
    Estudiante estudiante;

    @ManyToOne
    @MapsId("idAsignatura")
    @JoinColumn(name = "id_asignatura")
    @JsonManagedReference
    Asignatura asignatura;

    double nota;
}