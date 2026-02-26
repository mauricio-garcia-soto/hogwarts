package com.example.howgarts.controller;

import com.example.howgarts.dto.ProfesorDto;
import com.example.howgarts.mapper.ProfesorMapper;
import com.example.howgarts.model.Profesor;
import com.example.howgarts.service.ProfesorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
@Tag(name = "Profesores", description = "Gestión del profesorado de Hogwarts")
public class ProfesorController {

    private final ProfesorService service;

    public ProfesorController(ProfesorService service) {
        this.service = service;
    }

    @Operation(summary = "Obtener todos los profesores")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de profesores obtenida correctamente")
    })
    @GetMapping
    public ResponseEntity<List<ProfesorDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Obtener un profesor por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Profesor encontrado"),
            @ApiResponse(responseCode = "404", description = "Profesor no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDto> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un nuevo profesor")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Profesor creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos del profesor inválidos")
    })
    @PostMapping
    public ResponseEntity<ProfesorDto> create(@RequestBody ProfesorDto profesorDto) {
        Profesor profesor = ProfesorMapper.toEntity(profesorDto);
        Profesor guardado = service.create(profesor);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProfesorMapper.toDTO(guardado));
    }

    @Operation(summary = "Actualizar los datos de un profesor")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Profesor actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Profesor no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProfesorDto> update(@PathVariable Long id, @RequestBody ProfesorDto profesorDto) {
        Profesor profesor = ProfesorMapper.toEntity(profesorDto);
        Profesor actualizado = service.update(id, profesor);
        return ResponseEntity.ok(ProfesorMapper.toDTO(actualizado));
    }

    @Operation(summary = "Eliminar un profesor por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Profesor eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Profesor no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}