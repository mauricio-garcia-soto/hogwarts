package com.example.howgarts.service.impl;

import com.example.howgarts.dto.CrearEstudianteDto;
import com.example.howgarts.dto.EstudianteDto;
import com.example.howgarts.dto.EstudianteUpdateDto;
import com.example.howgarts.mapper.EstudianteMapper;
import com.example.howgarts.model.Casa;
import com.example.howgarts.model.Estudiante;
import com.example.howgarts.model.Mascota;
import com.example.howgarts.repository.CasaRepository;
import com.example.howgarts.repository.EstudianteRepository;
import com.example.howgarts.service.EstudianteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final CasaRepository casaRepository;
    private final EstudianteMapper estudianteMapper;

    @Override
    public List<EstudianteDto> obtenerTodos() {
        return estudianteRepository.findAll().stream()
                .map(estudianteMapper::toDto)
                .toList();
    }

    @Override
    public EstudianteDto obtenerPorId(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estudiante no encontrado"));
        return estudianteMapper.toDto(estudiante);
    }

    @Override
    @Transactional
    public EstudianteDto crearEstudiante(CrearEstudianteDto dto) {
        Estudiante estudiante = estudianteMapper.toEntity(dto);
        Casa casa = casaRepository.findById(dto.getCasaId())
                .orElseThrow(() -> new NoSuchElementException("Casa no encontrada"));
        estudiante.setCasa(casa);

        if (estudiante.getMascota() != null) {
            estudiante.getMascota().setEstudiante(estudiante);
        }

        return estudianteMapper.toDto(estudianteRepository.save(estudiante));
    }


    @Override
    @Transactional
    public EstudianteDto actualizarEstudiante(Long id, EstudianteUpdateDto dto) {
        Estudiante existente = estudianteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estudiante no encontrado"));


        estudianteMapper.updateEntityFromUpdateDto(dto, existente);


        if (dto.getCasaId() != null) {
            Casa casa = casaRepository.findById(dto.getCasaId())
                    .orElseThrow(() -> new NoSuchElementException("Casa no encontrada"));
            existente.setCasa(casa);
        }


        if (dto.getMascota() != null) {
            if (existente.getMascota() == null) {
                Mascota nueva = new Mascota();
                nueva.setNombre(dto.getMascota().getNombre());
                nueva.setEspecie(dto.getMascota().getEspecie());
                existente.setMascota(nueva);
            } else {
                existente.getMascota().setNombre(dto.getMascota().getNombre());
                existente.getMascota().setEspecie(dto.getMascota().getEspecie());
            }
        }


        Estudiante guardado = estudianteRepository.save(existente);
        return estudianteMapper.toDto(guardado);
    }
    @Override
    @Transactional
    public void eliminarEstudiante(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se puede eliminar"));
        estudianteRepository.delete(estudiante);
    }
}