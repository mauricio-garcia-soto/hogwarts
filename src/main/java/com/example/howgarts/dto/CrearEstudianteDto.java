package com.example.howgarts.dto;

import java.time.LocalDate;

public class CrearEstudianteDto {

        private String nombre;
        private String apellido;
        private int anyoCurso;
        private LocalDate fechaNacimiento;
        private int casaId;
        private MascotaDto mascota;


        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getApellido() { return apellido; }
        public void setApellido(String apellido) { this.apellido = apellido; }
        public int getAnyoCurso() { return anyoCurso; }
        public void setAnyoCurso(int anyoCurso) { this.anyoCurso = anyoCurso; }
        public LocalDate getFechaNacimiento() { return fechaNacimiento; }
        public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
        public int getCasaId() { return casaId; }
        public void setCasaId(int casaId) { this.casaId = casaId; }
        public MascotaDto getMascota() { return mascota; }
        public void setMascota(MascotaDto mascota) { this.mascota = mascota; }
    }

