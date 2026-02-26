package com.example.howgarts.controller;

import com.example.howgarts.dto.AsignaturaDto;
import com.example.howgarts.mapper.AsignaturaMapper;
import com.example.howgarts.model.Asignatura;
import com.example.howgarts.service.AsignaturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    private final AsignaturaService service;

    public AsignaturaController(AsignaturaService service) {
        this.service = service;
    }

    @GetMapping
    public List<AsignaturaDto> getAll() {
        return service.getAll().stream()
                .map(AsignaturaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignaturaDto> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(AsignaturaMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AsignaturaDto> create(@RequestBody AsignaturaDto asignaturaDto) {
        Asignatura asignatura = AsignaturaMapper.toEntity(asignaturaDto);
        Asignatura created = service.create(asignatura);
        return ResponseEntity.status(HttpStatus.CREATED).body(AsignaturaMapper.toDTO(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignaturaDto> update(@PathVariable Long id, @RequestBody AsignaturaDto asignaturaDto) {
        Asignatura asignatura = AsignaturaMapper.toEntity(asignaturaDto);
        Asignatura updated = service.update(id, asignatura);
        return ResponseEntity.ok(AsignaturaMapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}