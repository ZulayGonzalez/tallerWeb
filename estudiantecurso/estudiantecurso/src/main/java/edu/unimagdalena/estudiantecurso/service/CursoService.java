package edu.unimagdalena.estudiantecurso.service;

import edu.unimagdalena.estudiantecurso.model.Curso;
import edu.unimagdalena.estudiantecurso.repository.CursoRepository;
import edu.unimagdalena.estudiantecurso.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class CursoService implements ICursoService{

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Set<Curso> curso() {
        return null;
    }

    @Override
    public Curso create(Curso curso) {
        return null;
    }

    @Override
    public Curso find(Long id) {
        return null;
    }

    @Override
    public Curso edit(Curso curso, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
