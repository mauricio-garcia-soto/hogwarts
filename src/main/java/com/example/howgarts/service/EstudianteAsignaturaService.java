package com.example.howgarts.service;

import com.example.howgarts.model.EstudianteAsignatura;
import com.example.howgarts.model.EstudianteAsignaturaId;
import com.example.howgarts.repository.EstudianteAsignaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteAsignaturaService {

    private final EstudianteAsignaturaRepository repository;

    public EstudianteAsignaturaService(EstudianteAsignaturaRepository repository) {
        this.repository = repository;
    }

    public List<EstudianteAsignatura> getAll() {
        return repository.findAll();
    }

    public Optional<EstudianteAsignatura> getById(EstudianteAsignaturaId id) {
        return repository.findById(id);
    }

    public EstudianteAsignatura create(EstudianteAsignatura ea) {
        return repository.save(ea);
    }

    public EstudianteAsignatura update(EstudianteAsignatura ea) {
        return repository.save(ea);
    }

    public void delete(EstudianteAsignaturaId id) {
        repository.deleteById(id);
    }
}
