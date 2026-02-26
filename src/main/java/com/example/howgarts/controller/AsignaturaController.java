package com.example.howgarts.controller;

import com.example.howgarts.dto.AsignaturaDto;
import com.example.howgarts.mapper.AsignaturaMapper;
import com.example.howgarts.model.Asignatura;
import com.example.howgarts.service.AsignaturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/asignaturas")
@Tag(name = "Asignaturas", description = "Gestión de asignaturas de Hogwarts")
public class AsignaturaController {

    private final AsignaturaService service;

    public AsignaturaController(AsignaturaService service) {
        this.service = service;
    }

    @Operation(summary = "Obtener todas las asignaturas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de asignaturas obtenida correctamente")
    })
    @GetMapping
    public List<AsignaturaDto> getAll() {
        return service.getAll().stream()
                .map(AsignaturaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Obtener una asignatura por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Asignatura encontrada"),
            @ApiResponse(responseCode = "404", description = "Asignatura no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<AsignaturaDto> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(AsignaturaMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear una nueva asignatura")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Asignatura creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos de la asignatura inválidos")
    })
    @PostMapping
    public ResponseEntity<AsignaturaDto> create(@RequestBody AsignaturaDto asignaturaDto) {
        Asignatura asignatura = AsignaturaMapper.toEntity(asignaturaDto);
        Asignatura created = service.create(asignatura);
        return ResponseEntity.status(HttpStatus.CREATED).body(AsignaturaMapper.toDTO(created));
    }

    @Operation(summary = "Actualizar una asignatura existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Asignatura actualizada correctamente"),
            @ApiResponse(responseCode = "404", description = "Asignatura no encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<AsignaturaDto> update(@PathVariable Long id, @RequestBody AsignaturaDto asignaturaDto) {
        Asignatura asignatura = AsignaturaMapper.toEntity(asignaturaDto);
        Asignatura updated = service.update(id, asignatura);
        return ResponseEntity.ok(AsignaturaMapper.toDTO(updated));
    }

    @Operation(summary = "Eliminar una asignatura por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Asignatura eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Asignatura no encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}