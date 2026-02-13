package com.example.howgarts.service.impl;

import com.example.howgarts.dto.CrearEstudianteDto;
import com.example.howgarts.dto.EstudianteDto;
import com.example.howgarts.dto.EstudianteUpdateDto;
import com.example.howgarts.mapper.EstudianteMapper;
import com.example.howgarts.model.Casa;
import com.example.howgarts.model.Estudiante;
import com.example.howgarts.repository.CasaRepository;
import com.example.howgarts.repository.EstudianteRepository;
import com.example.howgarts.service.EstudianteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final CasaRepository casaRepository;
    private final EstudianteMapper estudianteMapper;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository,
                                 CasaRepository casaRepository,
                                 EstudianteMapper estudianteMapper) {
        this.estudianteRepository = estudianteRepository;
        this.casaRepository = casaRepository;
        this.estudianteMapper = estudianteMapper;
    }

    @Override
    public List<EstudianteDto> obtenerTodos() {
        return estudianteRepository.findAll()
                .stream()
                .map(estudianteMapper::toDto)
                .toList();
    }

    @Override
    public EstudianteDto obtenerPorId(int id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estudiante con id " + id + " no encontrado"));
        return estudianteMapper.toDto(estudiante);
    }

    @Override
    @Transactional
    public EstudianteDto crearEstudiante(CrearEstudianteDto dto) {
        Estudiante estudiante = estudianteMapper.toEntity(dto);

        Casa casa = casaRepository.findById(dto.getCasaId())
                .orElseThrow(() -> new NoSuchElementException("Casa no encontrada con ID: " + dto.getCasaId()));
        estudiante.setCasa(casa);

        if (estudiante.getMascota() != null) {
            estudiante.getMascota().setEstudiante(estudiante);
        }

        Estudiante guardado = estudianteRepository.save(estudiante);
        return estudianteMapper.toDto(guardado);
    }

    @Override
    @Transactional
    public EstudianteDto actualizarEstudiante(int id, EstudianteUpdateDto dto) {
        Estudiante existente = estudianteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estudiante no encontrado con id: " + id));

        CrearEstudianteDto datosParaMapper = new CrearEstudianteDto();
        datosParaMapper.setAnyoCurso(dto.getAnyoCurso());
        datosParaMapper.setFechaNacimiento(dto.getFechaNacimiento());
        datosParaMapper.setMascota(dto.getMascota());

        estudianteMapper.updateEntityFromDto(datosParaMapper, existente);

        if (existente.getMascota() != null) {
            existente.getMascota().setEstudiante(existente);
        }

        Estudiante actualizado = estudianteRepository.save(existente);
        return estudianteMapper.toDto(actualizado);
    }

    @Override
    @Transactional
    public void eliminarEstudiante(int id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("El usuario con ID " + id + " no existe."));

        estudianteRepository.delete(estudiante);

    }
}