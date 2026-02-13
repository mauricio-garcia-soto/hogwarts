package com.example.howgarts.controller;


import com.example.howgarts.dto.ProfesorDto;
import com.example.howgarts.model.Profesor;
import com.example.howgarts.service.ProfesorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService service;

    public ProfesorController(ProfesorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProfesorDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDto> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Profesor> create(@RequestBody Profesor profesor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(profesor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesor> update(@PathVariable Integer id, @RequestBody Profesor profesor) {
        return ResponseEntity.ok(service.update(id, profesor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
