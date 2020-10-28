package edu.unimagdalena.estudiantecurso.service;

import edu.unimagdalena.estudiantecurso.model.Estudiante;

import java.util.Set;

public interface IEstudianteService {
    public Set<Estudiante> estudiantes();
    public Estudiante create(Estudiante estudiante);
    public Estudiante find(Long id);
    public Estudiante edit(Estudiante estudiante, Long id);
    public void  delete(Long id);
}
