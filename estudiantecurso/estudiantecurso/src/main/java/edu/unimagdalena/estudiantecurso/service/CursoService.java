package edu.unimagdalena.estudiantecurso.service;

import edu.unimagdalena.estudiantecurso.model.Curso;
import edu.unimagdalena.estudiantecurso.model.Estudiante;
import edu.unimagdalena.estudiantecurso.repository.CursoRepository;
import edu.unimagdalena.estudiantecurso.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class CursoService implements ICursoService{

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Set<Curso> curso() {

        return (Set<Curso> CursoRepository);
    }

    @Override
    public Curso create(Curso curso) {
        return CursoRepository.save(curso);
    }

    @Override
    public Curso find(Long id) {
        return CursoRepository.findById(id).orElse(null);
    }

    @Override
    public Curso edit(Curso curso, Long id) {
        Curso CursoToUpdate = CursoRepository.findById(id).get();

        return CursoToUpdate;
    }

    @Override
    public void delete(Long id) {
        CursoRepository.deleteById(id);
    }
}
