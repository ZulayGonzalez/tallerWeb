package edu.unimagdalena.tallerweb.model;


import javax.persistence.*;

@Entity
@Table(name = "cursos")

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


}
