package edu.unimagdalena.estudiantecurso.repository;

import edu.unimagdalena.estudiantecurso.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository <Estudiante, Long>{
    
	Estudiante findByNombre(String nombre);
    
    Estudiante findByCodigo(String codigo);
    
    Estudiante findByIdentificacion(String identificacion);
    
}
