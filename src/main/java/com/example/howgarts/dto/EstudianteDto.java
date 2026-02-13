package com.example.howgarts.dto;

import java.time.LocalDate;
import java.util.List;

public class EstudianteDto {
    private Long id;
    private String nombre;
    private int anyoCurso;
    private LocalDate fechaNacimiento;
    private String casa;
    private MascotaDto mascota;
    private List<AsignaturaCalificacionDto> asignaturas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnyoCurso() {
        return anyoCurso;
    }

    public void setAnyoCurso(int anyoCurso) {
        this.anyoCurso = anyoCurso;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public MascotaDto getMascota() {
        return mascota;
    }

    public void setMascota(MascotaDto mascota) {
        this.mascota = mascota;
    }

    public List<AsignaturaCalificacionDto> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<AsignaturaCalificacionDto> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
