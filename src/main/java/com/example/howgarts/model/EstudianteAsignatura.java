package com.example.howgarts.model;


import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "estudiante_asignatura")
@IdClass(EstudianteAsignaturaId.class)
public class EstudianteAsignatura {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_asignatura", nullable = false)
    private Asignatura asignatura;

    @Column(precision = 3, scale = 1)
    private BigDecimal calificacion;

    // Getters y setters
    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }

    public Asignatura getAsignatura() { return asignatura; }
    public void setAsignatura(Asignatura asignatura) { this.asignatura = asignatura; }

    public BigDecimal getCalificacion() { return calificacion; }
    public void setCalificacion(BigDecimal calificacion) { this.calificacion = calificacion; }
}