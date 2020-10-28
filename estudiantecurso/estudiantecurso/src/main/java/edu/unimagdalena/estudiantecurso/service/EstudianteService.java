package edu.unimagdalena.estudiantecurso.service;

import edu.unimagdalena.estudiantecurso.model.Estudiante;
import edu.unimagdalena.estudiantecurso.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class EstudianteService implements  IEstudianteService{

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public Set<Estudiante> estudiantes() {
        return null;
    }

    @Override
    public Estudiante create(Estudiante estudiante) {
        return null;
    }

    @Override
    public Estudiante find(Long id) {
        return null;
    }

    @Override
    public Estudiante edit(Estudiante estudiante, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
