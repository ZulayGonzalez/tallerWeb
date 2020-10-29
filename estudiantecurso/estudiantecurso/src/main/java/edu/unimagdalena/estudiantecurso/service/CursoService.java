package edu.unimagdalena.estudiantecurso.service;

import edu.unimagdalena.estudiantecurso.model.Curso;
import edu.unimagdalena.estudiantecurso.model.Estudiante;
import edu.unimagdalena.estudiantecurso.repository.CursoRepository;
import edu.unimagdalena.estudiantecurso.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CursoService implements ICursoService{

	@Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> curso() {
        return (List<Curso>) cursoRepository.findAll();
    }

    @Override
    public Curso create(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso find(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public Curso edit(Curso curso, Long id) {
        Curso CursoToUpdate = cursoRepository.findById(id).get();

        return CursoToUpdate;
    }

    @Override
    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }
}
