package edu.unimagdalena.tallerweb.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cursos")

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCur;

    @Column
    private String nombre;

    @Column
    private String codigo;

    @ManyToMany(mappedBy = "cursos")

    private Set<Estudiante> estudiantes;

    public Curso() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}