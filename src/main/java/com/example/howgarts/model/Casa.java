package com.example.howgarts.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "casa", cascade = CascadeType.ALL)
    private List<Estudiante> estudiantes;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor jefe; // Profesor que lidera la casa

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Estudiante> getEstudiantes() { return estudiantes; }
    public void setEstudiantes(List<Estudiante> estudiantes) { this.estudiantes = estudiantes; }

    public Profesor getJefe() { return jefe; }
    public void setJefe(Profesor jefe) { this.jefe = jefe; }
}