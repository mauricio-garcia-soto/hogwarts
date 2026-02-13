package com.example.howgarts.mapper;

import com.example.howgarts.dto.MascotaDto;
import com.example.howgarts.model.Mascota;

public class MascotaMapper {

    public static MascotaDto toDTO(Mascota mascota) {
        if (mascota == null) return null;

        MascotaDto dto = new MascotaDto();
        dto.setId(mascota.getId());
        dto.setNombre(mascota.getNombre());
        dto.setEspecie(mascota.getEspecie());

        if (mascota.getEstudiante() != null) {
            dto.setEstudiante(mascota.getEstudiante().getNombre());
        }

        return dto;
    }
}