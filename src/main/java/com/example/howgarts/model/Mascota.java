package com.example.howgarts.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMascota;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String especie;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    // Getters y setters
    public Integer getIdMascota() { return idMascota; }
    public void setIdMascota(Integer idMascota) { this.idMascota = idMascota; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }
}