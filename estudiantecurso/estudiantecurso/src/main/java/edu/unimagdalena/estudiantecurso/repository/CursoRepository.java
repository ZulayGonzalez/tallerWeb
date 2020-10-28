package edu.unimagdalena.estudiantecurso.repository;

import edu.unimagdalena.estudiantecurso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository <Curso, Long> {
    Curso findByNombre(String nombre);
}
