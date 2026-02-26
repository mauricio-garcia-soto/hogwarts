package com.example.howgarts.controller;

import com.example.howgarts.dto.CasaDto;
import com.example.howgarts.model.Casa;
import com.example.howgarts.service.CasaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/casas")
public class CasaController {

    private final CasaService service;

    public CasaController(CasaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CasaDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasaDto> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Casa> create(@RequestBody Casa casa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(casa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Casa> update(@PathVariable Long id, @RequestBody Casa casa) {
        return ResponseEntity.ok(service.update(id, casa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
