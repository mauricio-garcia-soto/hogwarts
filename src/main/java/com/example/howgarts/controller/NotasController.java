package com.example.howgarts.controller;

import com.example.howgarts.model.Nota;
import com.example.howgarts.service.NotaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
@Tag(name = "Notas", description = "Gestión de notas de los estudiantes")
public class NotasController {

    private final NotaService notaService;

    @Autowired
    public NotasController(NotaService notaService) {
        this.notaService = notaService;
    }

    @Operation(summary = "Obtener todas las notas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de notas obtenida correctamente"),
            @ApiResponse(responseCode = "204", description = "No hay notas registradas")
    })
    @GetMapping
    public ResponseEntity<List<Nota>> obtenerTodasLasNotas() {
        List<Nota> notas = notaService.obtenerTodas();
        if (notas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(notas);
    }

    @Operation(summary = "Crear una nueva nota")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Nota creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos de la nota inválidos")
    })
    @PostMapping
    public ResponseEntity<Nota> crearNota(@RequestBody Nota nota) {
        Nota nuevaNota = notaService.guardarNota(nota);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNota);
    }
}