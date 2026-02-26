package com.example.howgarts.service;

import com.example.howgarts.model.Nota;
import com.example.howgarts.model.Estudiante;
import com.example.howgarts.model.Asignatura;
import com.example.howgarts.repository.NotaRepository;
import org.springframework.stereotype.Service;

@Service
public class NotaService {

    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public Nota guardarNota(Nota nota) {

        Estudiante e = new Estudiante();
        Asignatura a = new Asignatura();


        e.setIdEstudiante(nota.getIdNota().getIdEstudiante());
        a.setIdAsignatura(nota.getIdNota().getIdAsignatura());


        nota.setEstudiante(e);
        nota.setAsignatura(a);

        return notaRepository.save(nota);
    }

    public java.util.List<Nota> obtenerTodas() {
        return notaRepository.findAll();
    }
}