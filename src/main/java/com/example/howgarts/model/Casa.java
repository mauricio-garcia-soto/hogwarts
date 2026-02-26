package com.example.howgarts.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "casa")
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_casa")
    private Long idCasa;

    private String nombre;
    private String fundador;
    private String fantasma;

    @OneToMany(mappedBy = "casa")
    @JsonManagedReference("estudiante-casa")
    private List<Estudiante> estudiantes;

    @OneToOne
    @JoinColumn(name = "id_jefe")
    @JsonManagedReference
    private Profesor jefe;


}