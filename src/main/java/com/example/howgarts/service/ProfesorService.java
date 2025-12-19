package com.example.howgarts.service;

import com.example.howgarts.model.Profesor;
import com.example.howgarts.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public List<Profesor> getAll() {
        return profesorRepository.findAll();
    }

    public Optional<Profesor> getById(Integer id) {
        return profesorRepository.findById(id);
    }

    public Profesor create(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public Profesor update(Integer id, Profesor profesor) {
        profesor.setId(id.longValue());
        return profesorRepository.save(profesor);
    }

    public void delete(Integer id) {
        profesorRepository.deleteById(id);
    }
}
