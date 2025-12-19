package com.example.howgarts.model;

import java.io.Serializable;
import java.util.Objects;

public class EstudianteAsignaturaId implements Serializable {

    private Integer estudiante;
    private Integer asignatura;

    public EstudianteAsignaturaId() {}

    public EstudianteAsignaturaId(Integer estudiante, Integer asignatura) {
        this.estudiante = estudiante;
        this.asignatura = asignatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstudianteAsignaturaId)) return false;
        EstudianteAsignaturaId that = (EstudianteAsignaturaId) o;
        return Objects.equals(estudiante, that.estudiante) &&
                Objects.equals(asignatura, that.asignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estudiante, asignatura);
    }
}
