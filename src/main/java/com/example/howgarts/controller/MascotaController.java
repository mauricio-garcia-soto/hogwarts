package com.example.howgarts.controller;

import com.example.howgarts.dto.MascotaDto;
import com.example.howgarts.model.Mascota;
import com.example.howgarts.service.MascotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    private final MascotaService service;

    public MascotaController(MascotaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MascotaDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaDto> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mascota> create(@RequestBody Mascota mascota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(mascota));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascota> update(@PathVariable Long id, @RequestBody Mascota mascota) {
        return ResponseEntity.ok(service.update(id, mascota));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
