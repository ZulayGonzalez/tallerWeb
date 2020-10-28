package edu.unimagdalena.tallerweb.Controller;

import edu.unimagdalena.tallerweb.model.Curso;

import java.util.List;
import java.util.Set;

public interface CursoServicio {
    public Set<Curso> cursos();
    public Curso create(Curso curso);
    public Curso find(Long idCur);
    public Curso edit(Curso curso, Long idCur);
    public void  delete(Long idCur);

}
