package com.example.howgarts.controller;

import com.example.howgarts.dto.CasaDto;
import com.example.howgarts.model.Casa;
import com.example.howgarts.service.CasaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/casas")
@Tag(name = "Casas", description = "Gestión de las casas de Hogwarts (Gryffindor, Slytherin, etc.)")
public class CasaController {

    private final CasaService service;

    public CasaController(CasaService service) {
        this.service = service;
    }

    @Operation(summary = "Obtener todas las casas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de casas obtenida correctamente")
    })
    @GetMapping
    public ResponseEntity<List<CasaDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Obtener una casa por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Casa encontrada"),
            @ApiResponse(responseCode = "404", description = "Casa no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CasaDto> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear una nueva casa")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Casa creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos de la casa inválidos")
    })
    @PostMapping
    public ResponseEntity<Casa> create(@RequestBody Casa casa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(casa));
    }

    @Operation(summary = "Actualizar una casa existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Casa actualizada correctamente"),
            @ApiResponse(responseCode = "404", description = "Casa no encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Casa> update(@PathVariable Long id, @RequestBody Casa casa) {
        return ResponseEntity.ok(service.update(id, casa));
    }

    @Operation(summary = "Eliminar una casa por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Casa eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Casa no encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}