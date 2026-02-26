package com.example.howgarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;

@Data
@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfesor;

    private String nombre;
    private String apellido;
    private Date fechaInicio;

    @OneToOne(mappedBy = "jefe")
    @JsonBackReference
    private Casa casa;


    @OneToOne
    @JoinColumn(name = "id_asignatura")
    @JsonManagedReference
    private Asignatura asignatura;
}