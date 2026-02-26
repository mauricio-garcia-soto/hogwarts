package com.example.howgarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsignatura;

    private String nombreAsignatura;
    private String aula;
    private Boolean obligatoria;


    @OneToOne(mappedBy = "asignatura")
    @JsonBackReference
    private Profesor profesor;

    @OneToMany(mappedBy = "asignatura")
    @JsonManagedReference("asignatura-nota")
    private List<Nota> notas;
}