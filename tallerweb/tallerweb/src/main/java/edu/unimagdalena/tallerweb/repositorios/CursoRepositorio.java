package edu.unimagdalena.tallerweb.model.repositorios;

import edu.unimagdalena.tallerweb.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepositorio extends JpaRepository<Curso, Long> {
    edu.unimagdalena.tallerweb.model.Curso findByNombre(String nombre);

}
