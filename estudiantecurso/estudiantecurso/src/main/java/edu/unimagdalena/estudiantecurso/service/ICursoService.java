package edu.unimagdalena.estudiantecurso.service;

import edu.unimagdalena.estudiantecurso.model.Curso;

import java.util.Set;

public interface ICursoService {
    public Set<Curso> curso();
    public Curso create(Curso curso);
    public Curso find(Long id);
    public Curso edit(Curso curso, Long id);
    public void  delete(Long id);
}
