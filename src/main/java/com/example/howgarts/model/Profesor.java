package com.example.howgarts.model;

import jakarta.persistence.*;

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


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Asignatura getAsignatura() { return asignatura; }
    public void setAsignatura(Asignatura asignatura) { this.asignatura = asignatura; }

    public Casa getCasa() { return casa; }
    public void setCasa(Casa casa) { this.casa = casa; }

    public java.time.LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(java.time.LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
}