package com.example.howgarts.controller;
import com.example.howgarts.model.Asignatura;
import com.example.howgarts.service.AsignaturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    private final AsignaturaService service;

    public AsignaturaController(AsignaturaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Asignatura>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Asignatura> create(@RequestBody Asignatura asignatura) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(asignatura));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> update(@PathVariable Integer id, @RequestBody Asignatura asignatura) {
        return ResponseEntity.ok(service.update(id, asignatura));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}