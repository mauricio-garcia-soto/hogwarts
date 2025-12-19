package com.example.howgarts.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "jefe", cascade = CascadeType.ALL)
    private List<Casa> casas;

    @ManyToMany
    @JoinTable(
            name = "profesor_asignatura",
            joinColumns = @JoinColumn(name = "profesor_id"),
            inverseJoinColumns = @JoinColumn(name = "asignatura_id")
    )
    private List<Asignatura> asignaturas;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Casa> getCasas() { return casas; }
    public void setCasas(List<Casa> casas) { this.casas = casas; }

    public List<Asignatura> getAsignaturas() { return asignaturas; }
    public void setAsignaturas(List<Asignatura> asignaturas) { this.asignaturas = asignaturas; }
}