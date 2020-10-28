package edu.unimagdalena.tallerweb.Controller;

import edu.unimagdalena.tallerweb.model.Curso;
import edu.unimagdalena.tallerweb.model.Estudiante;

import java.util.Set;

public interface EstudianteServicio {
    public Set<Estudiante> estudiantes();
    public Estudiante create(Estudiante estudiante);
    public Estudiante find(Long idEst);
    public Estudiante edit(Estudiante estudiante, Long idEst);
    public void  delete(Long idEst);
}
