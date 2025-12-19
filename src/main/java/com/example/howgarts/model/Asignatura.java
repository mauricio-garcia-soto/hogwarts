package com.example.howgarts.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "asignaturas")
    private List<Profesor> profesores;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Profesor> getProfesores() { return profesores; }
    public void setProfesores(List<Profesor> profesores) { this.profesores = profesores; }
}