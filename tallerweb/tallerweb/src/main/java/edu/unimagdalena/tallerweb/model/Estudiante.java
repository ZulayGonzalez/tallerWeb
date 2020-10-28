package edu.unimagdalena.tallerweb.model;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nombre;

    @Column String codigo;

    @Column
    private String numero;

    @ManyToMany
    @JoinTable (
            name = "cursos_estudiantes",
            joinColumns = @JoinColumn(name = "estudiante_id"),
            inverseJoinColumns = @JoinColumn(name= "cursos_id"))
      private Set<Curso> cursos;

    public Estudiante() {
        super();
    }

    public long getId() {
        return id;
    }

}
}
