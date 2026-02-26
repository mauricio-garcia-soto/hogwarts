package com.example.howgarts.mapper;

import com.example.howgarts.dto.ProfesorDto;
import com.example.howgarts.model.Profesor;
import java.sql.Date;

public class ProfesorMapper {

    public static ProfesorDto toDTO(Profesor profesor) {
        if (profesor == null) return null;

        ProfesorDto dto = new ProfesorDto();
        dto.setId(profesor.getIdProfesor());
        dto.setNombre(profesor.getNombre());
        dto.setApellido(profesor.getApellido());

        // 1. Convertimos java.sql.Date de la entidad a LocalDate del DTO
        if (profesor.getFechaInicio() != null) {
            dto.setFechaInicio(profesor.getFechaInicio().toLocalDate());
        }

        // 2. Sacamos solo el nombre de la asignatura (Relación 1 a 1)
        if (profesor.getAsignatura() != null) {
            dto.setAsignatura(profesor.getAsignatura().getNombreAsignatura());
        }

        return dto;
    }

    public static Profesor toEntity(ProfesorDto dto) {
        if (dto == null) return null;

        Profesor profesor = new Profesor();
        profesor.setIdProfesor(dto.getId());
        profesor.setNombre(dto.getNombre());
        profesor.setApellido(dto.getApellido());

        // Convertimos el LocalDate del DTO a java.sql.Date para la base de datos
        if (dto.getFechaInicio() != null) {
            profesor.setFechaInicio(Date.valueOf(dto.getFechaInicio()));
        }

        return profesor;
    }
}