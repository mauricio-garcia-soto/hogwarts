package com.example.howgarts.mapper;


import com.example.howgarts.dto.AsignaturaCalificacionDto;
import com.example.howgarts.model.Asignatura;

public class AsignaturaCalificacionMapper {

    public static AsignaturaCalificacionDto toDTO(Asignatura asignatura, Double calificacion) {
        if (asignatura == null) return null;

        AsignaturaCalificacionDto dto = new AsignaturaCalificacionDto();
        dto.setAsignatura(asignatura.getNombre());
        dto.setCalificacion(calificacion);
        return dto;
    }
}