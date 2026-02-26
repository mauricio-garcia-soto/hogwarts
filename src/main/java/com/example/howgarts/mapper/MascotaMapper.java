package com.example.howgarts.mapper;
import com.example.howgarts.dto.MascotaDto;
import com.example.howgarts.model.Mascota;
import org.springframework.stereotype.Component;

@Component
public class MascotaMapper {

    public MascotaDto toDTO(Mascota mascota) {
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

    public Mascota toEntity(MascotaDto dto) {
        if (dto == null) return null;

        Mascota mascota = new Mascota();

        if (dto.getId() != null) {
            mascota.setId(dto.getId());
        }
        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());

        return mascota;
    }
}