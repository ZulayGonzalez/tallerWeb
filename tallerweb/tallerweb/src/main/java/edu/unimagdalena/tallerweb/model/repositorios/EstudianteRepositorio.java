package edu.unimagdalena.tallerweb.model.repositorios;

import edu.unimagdalena.tallerweb.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepositorio extends JpaRepository <Estudiante, Long>{
    edu.unimagdalena.tallerweb.model.Estudiante findByNombre(String nombre);
}
