package edu.unimagdalena.estudiantecurso.service;

import edu.unimagdalena.estudiantecurso.model.Estudiante;
import edu.unimagdalena.estudiantecurso.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EstudianteService implements  IEstudianteService{

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> estudiantes() {

        return (List<Estudiante>) estudianteRepository.findAll();
    }

    @Override
    public Estudiante create(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante find(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    @Override
    public Estudiante edit(Estudiante estudiante, Long id) {
        Estudiante EstudianteToUpdate = estudianteRepository.findById(id).get();

        return EstudianteToUpdate;
    }

    @Override
    public void delete(Long id) {
    	estudianteRepository.deleteById(id);
    }
}
