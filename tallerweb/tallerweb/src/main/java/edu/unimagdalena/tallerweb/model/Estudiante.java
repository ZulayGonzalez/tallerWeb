package edu.unimagdalena.tallerweb.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEst;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo", nullable = false, unique = true)
    private String codigo;

    @Column
    private String numero;

    @ManyToMany
    @JoinTable (
            name = "cursos_estudiantes",
            joinColumns = @JoinColumn(name = "estudiante_id", referencedColumnName = "idEst"),
            inverseJoinColumns = @JoinColumn(name= "cursos_id", referencedColumnName = "idCur"))
      private Set<Curso> cursos;

    public Estudiante() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
}
