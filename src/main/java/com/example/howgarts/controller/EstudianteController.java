package com.example.howgarts.controller;

import com.example.howgarts.model.Estudiante;
import com.example.howgarts.service.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estudiante> create(@RequestBody Estudiante estudiante) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(estudiante));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> update(@PathVariable Integer id, @RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(service.update(id, estudiante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}