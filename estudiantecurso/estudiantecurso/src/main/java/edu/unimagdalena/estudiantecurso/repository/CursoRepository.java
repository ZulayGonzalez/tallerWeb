package edu.unimagdalena.estudiantecurso.repository;

import edu.unimagdalena.estudiantecurso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository <Curso, Long> {
    Curso findByNombre(String nombre);
    
    Curso findByCodigo(String codigo);
}
