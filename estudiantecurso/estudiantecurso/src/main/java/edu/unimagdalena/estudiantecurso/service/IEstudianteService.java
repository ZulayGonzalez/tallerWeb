package edu.unimagdalena.estudiantecurso.service;

import edu.unimagdalena.estudiantecurso.model.Estudiante;

import java.util.List;


public interface IEstudianteService {
	
    public List<Estudiante> estudiantes();
    
    public Estudiante create(Estudiante estudiante);
    
    public Estudiante find(Long id);
    
    public Estudiante edit(Estudiante estudiante, Long id);
    
    public void  delete(Long id);
    
}
