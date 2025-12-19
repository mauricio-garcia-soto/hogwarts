package com.example.howgarts.controller;

import com.example.howgarts.model.EstudianteAsignatura;
import com.example.howgarts.model.EstudianteAsignaturaId;
import com.example.howgarts.service.EstudianteAsignaturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiante-asignaturas")
public class EstudianteAsignaturaController {

    private final EstudianteAsignaturaService service;

    public EstudianteAsignaturaController(EstudianteAsignaturaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EstudianteAsignatura>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{estudianteId}/{asignaturaId}")
    public ResponseEntity<EstudianteAsignatura> getById(@PathVariable Integer estudianteId,
                                                        @PathVariable Integer asignaturaId) {
        EstudianteAsignaturaId id = new EstudianteAsignaturaId(estudianteId, asignaturaId);
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstudianteAsignatura> create(@RequestBody EstudianteAsignatura ea) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(ea));
    }

    @PutMapping
    public ResponseEntity<EstudianteAsignatura> update(@RequestBody EstudianteAsignatura ea) {
        return ResponseEntity.ok(service.update(ea));
    }

    @DeleteMapping("/{estudianteId}/{asignaturaId}")
    public ResponseEntity<Void> delete(@PathVariable Integer estudianteId,
                                       @PathVariable Integer asignaturaId) {
        EstudianteAsignaturaId id = new EstudianteAsignaturaId(estudianteId, asignaturaId);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
