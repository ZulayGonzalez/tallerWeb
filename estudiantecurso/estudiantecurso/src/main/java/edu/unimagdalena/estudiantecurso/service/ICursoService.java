package edu.unimagdalena.estudiantecurso.service;

import edu.unimagdalena.estudiantecurso.model.Curso;
import edu.unimagdalena.estudiantecurso.model.Estudiante;

import java.util.List;
import java.util.Set;

public interface ICursoService {
	
    public List<Curso> curso();
    
    public Curso create(Curso curso);
    
    public Curso find(Long id);
    
    public Curso edit(Curso curso, Long id);
    
    public void  delete(Long id);
}
