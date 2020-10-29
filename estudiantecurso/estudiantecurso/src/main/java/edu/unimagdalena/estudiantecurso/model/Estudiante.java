package edu.unimagdalena.estudiantecurso.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo", nullable = false, unique = true)
    private String codigo;

    @Column(name = "identificacion",nullable = false, unique = true)
    private String identificacion;

    @ManyToMany
    @JoinTable (
            name = "cursos_estudiantes",
            joinColumns = @JoinColumn(name = "estudiante_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name= "cursos_id", referencedColumnName = "id"))
    private Set<Curso> cursos;

    public Estudiante(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
