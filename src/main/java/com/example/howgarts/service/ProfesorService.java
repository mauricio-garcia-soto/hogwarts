package com.example.howgarts.service;

import com.example.howgarts.dto.ProfesorDto;
import com.example.howgarts.mapper.ProfesorMapper;
import com.example.howgarts.model.Profesor;
import com.example.howgarts.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public List<ProfesorDto> getAll() {
        return profesorRepository.findAll().stream().map(ProfesorMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<ProfesorDto> getById(Long id) {
        return profesorRepository.findById(id).map(ProfesorMapper::toDTO);
    }

    public Profesor create(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public Profesor update(Long id, Profesor profesor) {
        profesor.setIdProfesor(id);
        return profesorRepository.save(profesor);
    }

    public void delete(Long id) {
        profesorRepository.deleteById(id);
    }
}
