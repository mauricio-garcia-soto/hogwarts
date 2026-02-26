package com.example.howgarts.controller;

import com.example.howgarts.model.Nota;
import com.example.howgarts.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
public class NotasController {

    private final NotaService notaService;

    @Autowired
    public NotasController(NotaService notaService) {
        this.notaService = notaService;
    }

    @GetMapping
    public ResponseEntity<List<Nota>> obtenerTodasLasNotas() {
        List<Nota> notas = notaService.obtenerTodas();
        if (notas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(notas);
    }

    @PostMapping
    public ResponseEntity<Nota> crearNota(@RequestBody Nota nota) {
        Nota nuevaNota = notaService.guardarNota(nota);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNota);
    }
}