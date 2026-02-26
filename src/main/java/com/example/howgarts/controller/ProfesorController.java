package com.example.howgarts.controller;


import com.example.howgarts.dto.ProfesorDto;
import com.example.howgarts.mapper.ProfesorMapper;
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
    public ResponseEntity<ProfesorDto> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProfesorDto> create(@RequestBody ProfesorDto profesorDto) {

        Profesor profesor = ProfesorMapper.toEntity(profesorDto);


        Profesor guardado = service.create(profesor);


        return ResponseEntity.status(HttpStatus.CREATED).body(ProfesorMapper.toDTO(guardado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorDto> update(@PathVariable Long id, @RequestBody ProfesorDto profesorDto) {
        Profesor profesor = ProfesorMapper.toEntity(profesorDto);
        Profesor actualizado = service.update(id, profesor);
        return ResponseEntity.ok(ProfesorMapper.toDTO(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
