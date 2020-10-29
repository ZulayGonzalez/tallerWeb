package edu.unimagdalena.estudiantecurso.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column(name="codigo", unique = true, nullable = false)
    private String codigo;

    @ManyToMany(mappedBy = "cursos")
    private Set<Estudiante> estudiantes;

    public Curso(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
