package com.example.howgarts.mapper;

import com.example.howgarts.dto.CasaDto;
import com.example.howgarts.model.Casa;
import com.example.howgarts.model.Estudiante;

import java.util.stream.Collectors;

public class CasaMapper {

    public static CasaDto toDTO(Casa casa) {
        if (casa == null) return null;

        CasaDto dto = new CasaDto();
        dto.setId(casa.getId());
        dto.setNombre(casa.getNombre());
        dto.setFundador(casa.getFundador());
        dto.setFantasma(casa.getFantasma());

        if (casa.getJefe() != null) {
            dto.setJefe(ProfesorMapper.toDTO(casa.getJefe()));
        }

        dto.setEstudiantes(casa.getEstudiantes()
                .stream()
                .map(Estudiante::getNombre)
                .collect(Collectors.toList())
        );

        return dto;
    }
}