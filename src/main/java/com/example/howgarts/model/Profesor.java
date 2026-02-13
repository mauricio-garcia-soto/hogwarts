package com.example.howgarts.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToOne
    @JoinColumn(name = "profesor_asignatura")
    private Asignatura asignatura;

    @OneToOne
    @JoinColumn(name = "profesor_casa")
    private Casa casa;

    private java.time.LocalDate fechaInicio;

}