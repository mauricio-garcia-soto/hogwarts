package com.example.howgarts.controller;

import com.example.howgarts.dto.CrearEstudianteDto;
import com.example.howgarts.dto.EstudianteDto;
import com.example.howgarts.dto.EstudianteUpdateDto;
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
    public ResponseEntity<List<EstudianteDto>> getAll() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<EstudianteDto> create(@RequestBody CrearEstudianteDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearEstudiante(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDto> update(@PathVariable int id, @RequestBody EstudianteUpdateDto dto) {
        return ResponseEntity.ok(service.actualizarEstudiante(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.eliminarEstudiante(id);
        return ResponseEntity.noContent().build();
    }
}