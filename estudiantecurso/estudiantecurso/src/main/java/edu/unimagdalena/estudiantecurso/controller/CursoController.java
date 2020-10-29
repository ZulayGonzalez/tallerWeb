package edu.unimagdalena.estudiantecurso.controller;

import edu.unimagdalena.estudiantecurso.model.Curso;
import edu.unimagdalena.estudiantecurso.model.Estudiante;
import edu.unimagdalena.estudiantecurso.service.CursoService;
import edu.unimagdalena.estudiantecurso.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequestMapping("/api/v1/cursos")
@RestController
public class CursoController {
	
	@Autowired
	private CursoService cursoService;

	@GetMapping("/cursos")
	public List<Curso> cursos() {
		return cursoService.curso();
	}

	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody Curso curso) {
		
		// ResponseEntity devolver una respuesta de tipo json 
		// <> Map, HashMap, ..Map -> array bidimensional, <clave, valor> ej: <nombre, curso>
		// <?> Generics : Recibe cualquier objeto
		
		Map<String, Object> response = new HashMap<>();
		//<yogur, cilecco>
		
		Curso newCurso = null;

		try {
			newCurso = cursoService.create(curso);
			response.put("curso", newCurso);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
			
		} catch (Exception exception) {

			response.put("mensaje", "no se pudo crear curso");
			response.put("error", exception.getMessage());

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/editar/{id}")
	public ResponseEntity<?> find(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<String, Object>();

		Curso curso = null;

		try {

			curso = cursoService.find(id);

			if (curso == null) {

				response.put("mensaje", "no existe curso con id: ".concat(id.toString()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}

			response.put("mensaje", "curso " + id.toString() + " encontrado");
			response.put("curso", curso);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		} catch (DataAccessException dataAccessException) {
			response.put("mensaje", "error al buscar curso con id: " + id.toString());
			response.put("error", dataAccessException.getMessage()
					.concat(": " + dataAccessException.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Curso curso, @PathVariable Long id) {

		Map<String, Object> response = new HashMap<String, Object>();
		Curso cursoToUpdate = null;

		cursoToUpdate = cursoService.find(id);

		if (cursoToUpdate == null) {
			response.put("mensaje", "curso con id: ".concat(id.toString()).concat("no existe en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			cursoService.edit(curso, id);
			response.put("mensaje", "curso with id: ".concat(id.toString()).concat("actualizado"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (DataAccessException exception) {
			response.put("mensaje", "Error al editar: ".concat(id.toString()));
			response.put("error", exception.getMessage().concat(": " + exception.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<String, Object>();
		Curso curso = null;

		try {
			curso = cursoService.find(id);

			if (curso == null) {
				response.put("mensaje", "no existe curso con id: " + id.toString());
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}

			cursoService.delete(id);
			response.put("mensaje", "curso con id: ".concat(id.toString() + " ha sido elimindo"));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (DataAccessException dataAccessException) {
			response.put("respuesta", "no se pudo eliminar curso con id: " + id.toString());
			response.put("error", dataAccessException.getMessage()
					.concat(": " + dataAccessException.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
