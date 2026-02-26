package com.example.howgarts.service;

import com.example.howgarts.dto.AsignaturaDto;
import com.example.howgarts.mapper.AsignaturaMapper;
import com.example.howgarts.model.Asignatura;
import com.example.howgarts.repository.AsignaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    public AsignaturaService(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    public List<Asignatura> getAll() {
        return asignaturaRepository.findAll();
    }

    public Optional<Asignatura> getById(Long id) {
        return asignaturaRepository.findById(id);
    }


    public Asignatura create(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    public Asignatura update(Long id, Asignatura asignatura) {
        asignatura.setIdAsignatura(id);
        return asignaturaRepository.save(asignatura);
    }

    public void delete(Long id) {
        asignaturaRepository.deleteById(id);
    }
}