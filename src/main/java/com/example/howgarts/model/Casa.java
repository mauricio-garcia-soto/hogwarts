package com.example.howgarts.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
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


}