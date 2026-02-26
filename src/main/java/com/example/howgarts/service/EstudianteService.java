package com.example.howgarts.service;

import com.example.howgarts.dto.CrearEstudianteDto;
import com.example.howgarts.dto.EstudianteDto;
import com.example.howgarts.dto.EstudianteUpdateDto;
import java.util.List;

public interface EstudianteService {
    List<EstudianteDto> obtenerTodos();
    EstudianteDto obtenerPorId(Long id);
    EstudianteDto crearEstudiante(CrearEstudianteDto dto);
    EstudianteDto actualizarEstudiante(Long id, EstudianteUpdateDto dto);
    void eliminarEstudiante(Long id);
}