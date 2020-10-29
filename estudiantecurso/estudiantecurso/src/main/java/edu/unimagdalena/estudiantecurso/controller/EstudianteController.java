package edu.unimagdalena.estudiantecurso.controller;

import edu.unimagdalena.estudiantecurso.model.Estudiante;
import edu.unimagdalena.estudiantecurso.service.EstudianteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/api/v1/estudiantes")
@RestController
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/estudiantes")
    public List<Estudiante> estudiantes() {
        return estudianteService.estudiantes();
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody Estudiante estudiante){
        Map<String, Object> response = new HashMap<>();

        Estudiante newEstudiante= null;

        try {

            newEstudiante = estudianteService.create(estudiante);

            response.put("mensaje", "estudiante creado");
            response.put("jugador", newEstudiante);

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }catch(DataAccessException dataAccessException) {

            response.put("mensaje", "no se pudo crear jugador");
            response.put("error", dataAccessException.getMessage()
                    .concat(": "+ dataAccessException.getMostSpecificCause().getMessage()));

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Long id){

        Map<String, Object> response = new HashMap<String, Object>();

        Estudiante estudiante= null;

        try {

            estudiante = estudianteService.find(id);

            if(estudiante == null) {

                response.put("mensaje", "no existe estudiante con id: ".concat(id.toString()));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }

            response.put("mensaje", "estudiante "+ id.toString() + " encontrado");
            response.put("estudiante", estudiante);

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

        }catch(DataAccessException dataAccessException) {
            response.put("mensaje", "error al buscar estudiante con id: " + id.toString());
            response.put("error", dataAccessException.getMessage()
                    .concat(": " + dataAccessException.getMostSpecificCause().getMessage()));

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody Estudiante estudiante, @PathVariable Long id) {

        Map<String, Object> response = new HashMap<String, Object>();
        Estudiante estudianteToUpdate = null;

        estudianteToUpdate = estudianteService.find(id);

        if(estudianteToUpdate == null) {
            response.put("mensaje", "estudiante con id: ".concat(id.toString()).concat("no existe en la base de datos"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            estudianteService.edit(estudiante, id);
            response.put("mensaje", "estudiante with id: ".concat(id.toString()).concat("actualizado"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }catch(DataAccessException exception){
            response.put("mensaje", "Error al editar: ".concat(id.toString()));
            response.put("error", exception.getMessage()
                    .concat(": "+ exception.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        Map<String, Object> response = new HashMap<String, Object>();
        Estudiante estudiante = null;

        try {
            estudiante = estudianteService.find(id);

            if(estudiante == null) {
                response.put("mensaje", "no existe estudiante con id: "+ id.toString());
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }

            estudianteService.delete(id);
            response.put("mensaje", "estudiante con id: ".concat(id.toString() + " ha sido elimindo"));

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }catch(DataAccessException dataAccessException) {
            response.put("respuesta", "no se pudo eliminar estudiante con id: " + id.toString());
            response.put("error", dataAccessException.getMessage()
                    .concat(": " +  dataAccessException.getMostSpecificCause().getMessage()));

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
