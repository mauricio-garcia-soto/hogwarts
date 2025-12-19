package com.example.howgarts.service;

import com.example.howgarts.model.Estudiante;
import com.example.howgarts.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> getAll() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> getById(Integer id) {
        return estudianteRepository.findById(id);
    }

    public Estudiante create(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Estudiante update(Integer id, Estudiante estudiante) {
        estudiante.setId(Long.valueOf(id));
        return estudianteRepository.save(estudiante);
    }

    public void delete(Integer id) {
        estudianteRepository.deleteById(id);
    }
}
