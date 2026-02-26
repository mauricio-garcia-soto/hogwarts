package com.example.howgarts.controller;

import com.example.howgarts.dto.MascotaDto;
import com.example.howgarts.model.Mascota;
import com.example.howgarts.service.MascotaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
@Tag(name = "Mascotas", description = "Gestión de mascotas de los estudiantes de Hogwarts")
public class MascotaController {

    private final MascotaService service;

    public MascotaController(MascotaService service) {
        this.service = service;
    }

    @Operation(summary = "Obtener todas las mascotas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de mascotas obtenida correctamente")
    })
    @GetMapping
    public ResponseEntity<List<MascotaDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Obtener una mascota por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Mascota encontrada"),
            @ApiResponse(responseCode = "404", description = "Mascota no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MascotaDto> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar una nueva mascota")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Mascota registrada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos de la mascota inválidos")
    })
    @PostMapping
    public ResponseEntity<Mascota> create(@RequestBody Mascota mascota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(mascota));
    }

    @Operation(summary = "Actualizar los datos de una mascota")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Mascota actualizada correctamente"),
            @ApiResponse(responseCode = "404", description = "Mascota no encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Mascota> update(@PathVariable Long id, @RequestBody Mascota mascota) {
        return ResponseEntity.ok(service.update(id, mascota));
    }

    @Operation(summary = "Eliminar una mascota por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Mascota eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Mascota no encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}