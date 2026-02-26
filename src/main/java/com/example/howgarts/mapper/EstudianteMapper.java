package com.example.howgarts.mapper;

import com.example.howgarts.dto.CrearEstudianteDto;
import com.example.howgarts.dto.EstudianteUpdateDto;
import com.example.howgarts.dto.EstudianteDto;
import com.example.howgarts.dto.AsignaturaCalificacionDto;
import com.example.howgarts.model.Estudiante;
import com.example.howgarts.model.Mascota;
import com.example.howgarts.model.Nota;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstudianteMapper {

    private final MascotaMapper mascotaMapper;

    public EstudianteMapper(MascotaMapper mascotaMapper){
        this.mascotaMapper = mascotaMapper;
    }

    public EstudianteDto toDto(Estudiante estudiante){
        if(estudiante == null) return null;
        EstudianteDto dto = new EstudianteDto();
        dto.setId(estudiante.getIdEstudiante());
        dto.setNombre(estudiante.getNombre());
        if (estudiante.getAnyoCurso() != null) {
            dto.setAnyoCurso(Math.toIntExact(estudiante.getAnyoCurso()));
        }
        dto.setFechaNacimiento(estudiante.getFechaNacimiento());
        if (estudiante.getCasa() != null) {
            dto.setCasa(estudiante.getCasa().getNombre());
        }
        dto.setMascota(mascotaMapper.toDTO(estudiante.getMascota()));
        if (estudiante.getNotas() != null && !estudiante.getNotas().isEmpty()) {
            List<AsignaturaCalificacionDto> listaDtos = estudiante.getNotas().stream()
                    .map(nota -> {
                        AsignaturaCalificacionDto dtoo = new AsignaturaCalificacionDto();
                        if (nota.getAsignatura() != null) {
                            dtoo.setAsignatura(nota.getAsignatura().getNombreAsignatura());
                        }
                        dtoo.setCalificacion(nota.getCalificacion());
                        return dtoo;
                    }).collect(Collectors.toList());
            dto.setAsignaturas(listaDtos);
        } else {
            dto.setAsignaturas(new ArrayList<>());
        }
        return dto;
    }

    public Estudiante toEntity(CrearEstudianteDto estudianteDto){
        if(estudianteDto == null) return null;
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(estudianteDto.getNombre());
        estudiante.setApellido(estudianteDto.getApellido());
        estudiante.setAnyoCurso((long) estudianteDto.getAnyoCurso());
        estudiante.setFechaNacimiento(estudianteDto.getFechaNacimiento());
        if (estudianteDto.getMascota() != null) {
            estudiante.setMascota(mascotaMapper.toEntity(estudianteDto.getMascota()));
        }
        return estudiante;
    }
    public void updateEntityFromUpdateDto(EstudianteUpdateDto dto, Estudiante estudiante) {
        if (dto == null || estudiante == null) return;

        if (dto.getAnyoCurso() > 0) {
            estudiante.setAnyoCurso((long) dto.getAnyoCurso());
        }

        if (dto.getFechaNacimiento() != null) {
            estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        }
    }

    }
