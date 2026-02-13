package com.example.howgarts.mapper;

import com.example.howgarts.dto.ProfesorDto;
import com.example.howgarts.model.Profesor;

public class ProfesorMapper {

    public static ProfesorDto toDTO(Profesor profesor) {
        if (profesor == null) return null;

        ProfesorDto dto = new ProfesorDto();
        dto.setId(profesor.getId());
        dto.setNombre(profesor.getNombre());
        dto.setFechaInicio(profesor.getFechaInicio());

        if (profesor.getAsignatura() != null) {
            dto.setAsignatura(profesor.getAsignatura().getNombre());
        }

        return dto;
    }
}
