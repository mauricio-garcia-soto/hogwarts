package com.example.howgarts.repository;


import com.example.howgarts.model.EstudianteAsignatura;
import com.example.howgarts.model.EstudianteAsignaturaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteAsignaturaRepository extends JpaRepository<EstudianteAsignatura, EstudianteAsignaturaId> {
}
