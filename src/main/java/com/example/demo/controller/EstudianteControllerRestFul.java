package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

//http://localhost:8082/   API/v1.0/Matricula   /estudiantes   /consultar/{id}
// 							Proyecto Java 		  Servicio 		Capacidades

// API está representado por un proyecto Java.									 | Proyecto Java para API de Matriculación
// El Servicio está representado por una Clase Controller.       				 | El Servicio (este Controller) es estudiantes
// Las capacidades está representadas por los Métodos de esa clase controller. 	 | Las capacidades son los distintos [Endpoints]

@RestController
@RequestMapping(path = "/estudiantes") // debe ir en plural
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	// GET
	// Antes: http://localhost:8082/API/v1.0/Matricula/estudiantes/consultar/{id}
	// Despues: http://localhost:8082/API/v1.0/Matricula/estudiantes/{id} GET
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Estudiante> consultar(@PathVariable Integer id) {
		// 240: grupo de peticiones satisfactorias.
		// 240: Recurso Estudiante encontrado satisfactoriamente.
		Estudiante estu = this.estudianteService.buscar(id);
		//return ResponseEntity.status(241).body(estu);
		return ResponseEntity.status(HttpStatus.OK).body(estu);
	}

	// GET y filtrar
	// Antes:
	// http://localhost:8082/API/v1.0/Matricula/estudiantes/consultarTodos?genero=M&edad=100
	// Despues: http://localhost:8082/API/v1.0/Matricula/estudiantes?genero=M GET
	
	// PRODUCES CUANDO NO ES VOID
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<Estudiante>> consultarTodos(@RequestParam(required = false, defaultValue = "M") String genero) {
		List<Estudiante> lista = this.estudianteService.seleccionarTodos(genero);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_242", "Lista consultada de manera satisfactoria.");
		cabeceras.add("mensaje_info", "El sistema va estar en mantenimiento el fin de semana.");
		return new ResponseEntity<>(lista, cabeceras, 242);
	}

	// POST
	// Antes: http://localhost:8082/API/v1.0/Matricula/estudiantes/guardar
	// Despues: http://localhost:8082/API/v1.0/Matricula/estudiantes POST
	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}

	// PUT
	// Antes: http://localhost:8082/API/v1.0/Matricula/estudiantes/actualizar/{id}
	// Después: http://localhost:8082/API/v1.0/Matricula/estudiantes PUT
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		estudiante.setId(id);
		this.estudianteService.actualizar(estudiante);
	}

	// PATCH
	// http://localhost:8082/API/v1.0/Matricula/estudiantes/actualizarParcial/{id}
	// http://localhost:8082/API/v1.0/Matricula/estudiantes/{id} PATCH
	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_XML_VALUE)
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		this.estudianteService.actualizarParcial(estudiante.getApellido(), estudiante.getNombre(), id);
	}

	// DELETE
	// http://localhost:8082/API/v1.0/Matricula/estudiantes/{id} DELETE
	@DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_XML_VALUE)
	public void borrar(@PathVariable Integer id) {
		this.estudianteService.borrar(id);
	}

}
