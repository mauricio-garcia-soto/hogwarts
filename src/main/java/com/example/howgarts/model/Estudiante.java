package com.example.howgarts.model;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.time.LocalDate;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int anyoCurso;
    private LocalDate fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "id_casa")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Casa casa;


    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private Mascota mascota;

    @ManyToMany
    @JoinTable(
            name = "estudiante_asignatura",
            joinColumns = @JoinColumn(name = "id_estudiante"),
            inverseJoinColumns = @JoinColumn(name = "id_asignatura")
    )
    @OnDelete(action = OnDeleteAction.RESTRICT)

    private List<Asignatura> listaAsignaturas;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getAnyoCurso() { return anyoCurso; }
    public void setAnyoCurso(int anyoCurso) { this.anyoCurso = anyoCurso; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public Casa getCasa() { return casa; }
    public void setCasa(Casa casa) { this.casa = casa; }

    public Mascota getMascota() { return mascota; }
    public void setMascota(Mascota mascota) { this.mascota = mascota; }

    public List<Asignatura> getListaAsignaturas() { return listaAsignaturas; }
    public void setListaAsignaturas(List<Asignatura> listaAsignaturas) { this.listaAsignaturas = listaAsignaturas; }
}