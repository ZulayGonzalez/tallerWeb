package edu.unimagdalena.estudiantecurso.repository;

import edu.unimagdalena.estudiantecurso.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository <Estudiante, Long>{
    Estudiante findByNombre(String nombre);
}
