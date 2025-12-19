package com.example.howgarts.service;

import com.example.howgarts.model.Asignatura;
import com.example.howgarts.repository.AsignaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    public AsignaturaService(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    public List<Asignatura> getAll() {
        return asignaturaRepository.findAll();
    }

    public Optional<Asignatura> getById(Integer id) {
        return asignaturaRepository.findById(id);
    }

    public Asignatura create(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    public Asignatura update(Integer id, Asignatura asignatura) {
        asignatura.setId(id.longValue());
        return asignaturaRepository.save(asignatura);
    }

    public void delete(Integer id) {
        asignaturaRepository.deleteById(id);
    }
}