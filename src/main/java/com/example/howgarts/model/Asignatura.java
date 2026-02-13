package com.example.howgarts.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Asignatura {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String nombre;
private String aula;
private Boolean obligatoria;

@OneToOne(mappedBy = "asignatura")
private Profesor profesor;

@ManyToMany(mappedBy = "listaAsignaturas")
private List<Estudiante> estudiantes;

@OneToMany(mappedBy = "asignatura")
private List<Nota> notas;


}
