package com.example.howgarts.dto;

import java.time.LocalDate;

public class EstudianteUpdateDto {
    private int anyoCurso;
    private LocalDate fechaNacimiento;
    private MascotaDto mascota;


    public int getAnyoCurso() { return anyoCurso; }
    public void setAnyoCurso(int anyoCurso) { this.anyoCurso = anyoCurso; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public MascotaDto getMascota() { return mascota; }
    public void setMascota(MascotaDto mascota) { this.mascota = mascota; }
}
