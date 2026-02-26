package com.example.howgarts.repository;

import com.example.howgarts.model.Nota;
import com.example.howgarts.model.EstudianteAsignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<Nota, EstudianteAsignatura> {
}