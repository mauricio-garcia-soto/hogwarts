package com.example.howgarts.model;

import jakarta.persistence.*;
import java.util.List;

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


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getAula() { return aula; }
    public void setAula(String aula) { this.aula = aula; }

    public Boolean getObligatoria() { return obligatoria; }
    public void setObligatoria(Boolean obligatoria) { this.obligatoria = obligatoria; }

    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }

    public List<Estudiante> getEstudiantes() { return estudiantes; }
    public void setEstudiantes(List<Estudiante> estudiantes) { this.estudiantes = estudiantes; }
}
