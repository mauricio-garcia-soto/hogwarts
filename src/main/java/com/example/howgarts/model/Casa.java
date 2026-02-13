package com.example.howgarts.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String fundador;
    private String fantasma;

    @OneToMany(mappedBy = "casa",cascade = CascadeType.ALL)
    private List<Estudiante> estudiantes;

    @OneToOne(mappedBy = "casa")
    private Profesor jefe;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getFundador() { return fundador; }
    public void setFundador(String fundador) { this.fundador = fundador; }

    public String getFantasma() { return fantasma; }
    public void setFantasma(String fantasma) { this.fantasma = fantasma; }

    public List<Estudiante> getEstudiantes() { return estudiantes; }
    public void setEstudiantes(List<Estudiante> estudiantes) { this.estudiantes = estudiantes; }

    public Profesor getJefe() { return jefe; }
    public void setJefe(Profesor jefe) { this.jefe = jefe; }
}