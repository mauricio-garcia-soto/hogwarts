package com.example.howgarts.service.impl;

import com.example.howgarts.model.Nota;
import com.example.howgarts.model.Estudiante;
import com.example.howgarts.model.Asignatura;
import com.example.howgarts.repository.NotaRepository;
import com.example.howgarts.repository.EstudianteRepository;
import com.example.howgarts.repository.AsignaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class NotaServiceImpl {

    private final NotaRepository notaRepository;
    private final EstudianteRepository estudianteRepository;
    private final AsignaturaRepository asignaturaRepository;

    @Transactional
    public Nota guardarNota(Nota nota) {
        if (nota.getIdNota() == null) {
            throw new IllegalArgumentException("El ID de la nota no puede ser nulo");
        }

        Estudiante e = estudianteRepository.findById(nota.getIdNota().getIdEstudiante())
                .orElseThrow(() -> new NoSuchElementException("Estudiante no encontrado"));

        Asignatura a = asignaturaRepository.findById(nota.getIdNota().getIdAsignatura())
                .orElseThrow(() -> new NoSuchElementException("Asignatura no encontrada"));

        nota.setEstudiante(e);
        nota.setAsignatura(a);

        return notaRepository.save(nota);
    }

    public List<Nota> obtenerTodas() {
        return notaRepository.findAll();
    }
}