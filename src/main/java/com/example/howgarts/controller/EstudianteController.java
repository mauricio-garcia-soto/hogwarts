package com.example.howgarts.controller;

import com.example.howgarts.dto.CrearEstudianteDto;
import com.example.howgarts.dto.EstudianteDto;
import com.example.howgarts.dto.EstudianteUpdateDto;
import com.example.howgarts.service.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@Tag(name = "Estudiantes", description = "Gestión de estudiantes de Hogwarts")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @Operation(summary = "Obtener todos los estudiantes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de estudiantes obtenida correctamente")
    })
    @GetMapping
    public ResponseEntity<List<EstudianteDto>> getAll() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @Operation(summary = "Obtener un estudiante por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Estudiante encontrado"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @Operation(summary = "Crear un nuevo estudiante")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Estudiante creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos del estudiante inválidos")
    })
    @PostMapping
    public ResponseEntity<EstudianteDto> create(@RequestBody CrearEstudianteDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearEstudiante(dto));
    }

    @Operation(summary = "Actualizar los datos de un estudiante")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Estudiante actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDto> update(@PathVariable Long id, @RequestBody EstudianteUpdateDto dto) {
        return ResponseEntity.ok(service.actualizarEstudiante(id, dto));
    }

    @Operation(summary = "Eliminar un estudiante por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Estudiante eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.eliminarEstudiante(id);
        return ResponseEntity.noContent().build();
    }
}