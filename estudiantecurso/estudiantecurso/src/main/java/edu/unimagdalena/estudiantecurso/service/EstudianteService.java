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

        return (Set<Estudiante> EstudianteRepository);
    }

    @Override
    public Estudiante create(Estudiante estudiante) {
        return EstudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante find(Long id) {
        return EstudianteRepository.findById(id).orElse(null);
    }

    @Override
    public Estudiante edit(Estudiante estudiante, Long id) {
        Estudiante EstudianteToUpdate = EstudianteRepository.findById(id).get();

        return EstudianteToUpdate;
    }

    @Override
    public void delete(Long id) {
        EstudianteRepository.deleteById(id)
    }
}
