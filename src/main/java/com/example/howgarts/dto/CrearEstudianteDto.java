package com.example.howgarts.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CrearEstudianteDto {

        private String nombre;
        private String apellido;

        @Max(7)
        @Min(1)
        private int anyoCurso;
        private LocalDate fechaNacimiento;
        private long casaId;
        private MascotaDto mascota;
    }

