package com.example.howgarts.mapper;

import com.example.howgarts.dto.AsignaturaDto;
import com.example.howgarts.model.Asignatura;
import com.example.howgarts.model.Profesor;
import java.util.stream.Collectors;

public class AsignaturaMapper {

    public static AsignaturaDto toDTO(Asignatura asignatura) {
        if (asignatura == null) return null;
        AsignaturaDto dto = new AsignaturaDto();
        dto.setId(asignatura.getId());
        dto.setNombre(asignatura.getNombre());
        dto.setAula(asignatura.getAula());
        dto.setObligatoria(asignatura.getObligatoria());
        if (asignatura.getProfesor() != null) {
            dto.setProfesor(asignatura.getProfesor().getNombre());
        }
        return dto;
    }

    public static Asignatura toEntity(AsignaturaDto dto) {
        if (dto == null) return null;
        Asignatura asignatura = new Asignatura();
        asignatura.setId(dto.getId());
        asignatura.setNombre(dto.getNombre());
        asignatura.setAula(dto.getAula());
        asignatura.setObligatoria(dto.getObligatoria());
        return asignatura;
    }
}