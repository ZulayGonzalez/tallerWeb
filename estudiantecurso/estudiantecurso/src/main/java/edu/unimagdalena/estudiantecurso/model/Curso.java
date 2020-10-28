package edu.unimagdalena.estudiantecurso.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nombre;

    @Column
    private String codigo;

    @ManyToMany(mappedBy = "cursos")
    private Set<Estudiante> estudiantes;

    public Curso(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
