package com.example.howgarts.mapper;

import com.example.howgarts.dto.CrearEstudianteDto;
import com.example.howgarts.dto.EstudianteUpdateDto;
import com.example.howgarts.dto.EstudianteDto;
import com.example.howgarts.dto.MascotaDto;
import com.example.howgarts.model.Estudiante;
import com.example.howgarts.model.Mascota;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper {

    public EstudianteDto toDto(Estudiante estudiante) {
        if (estudiante == null) return null;

        EstudianteDto dto = new EstudianteDto();
        dto.setId(estudiante.getId());
        dto.setNombre(estudiante.getNombre());
        dto.setAnyoCurso(estudiante.getAnyoCurso());
        dto.setFechaNacimiento(estudiante.getFechaNacimiento());
        dto.setCasa(estudiante.getCasa() != null ? estudiante.getCasa().getNombre() : null);

        if (estudiante.getMascota() != null) {
            MascotaDto mascotaDto = new MascotaDto();
            mascotaDto.setId(estudiante.getMascota().getId());
            mascotaDto.setNombre(estudiante.getMascota().getNombre());
            mascotaDto.setEspecie(estudiante.getMascota().getEspecie());
            dto.setMascota(mascotaDto);
        }

        return dto;
    }

    public Estudiante toEntity(CrearEstudianteDto dto) {
        if (dto == null) return null;

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(dto.getNombre());
        estudiante.setAnyoCurso(dto.getAnyoCurso());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());

        if (dto.getMascota() != null) {
            Mascota mascota = new Mascota();
            mascota.setNombre(dto.getMascota().getNombre());
            mascota.setEspecie(dto.getMascota().getEspecie());
            estudiante.setMascota(mascota);
        }

        return estudiante;
    }

    public void updateEntityFromDto(CrearEstudianteDto dto, Estudiante estudiante) {
        if (dto == null || estudiante == null) return;

        estudiante.setAnyoCurso(dto.getAnyoCurso());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());

        if (dto.getMascota() == null) {
            estudiante.setMascota(null);
        } else {
            Mascota mascota = (estudiante.getMascota() != null) ? estudiante.getMascota() : new Mascota();
            mascota.setNombre(dto.getMascota().getNombre());
            mascota.setEspecie(dto.getMascota().getEspecie());
            estudiante.setMascota(mascota);
        }
    }
}