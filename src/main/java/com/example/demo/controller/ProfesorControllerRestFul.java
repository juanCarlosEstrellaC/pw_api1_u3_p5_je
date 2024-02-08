package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import com.example.demo.repository.modelo.Profesor;
import com.example.demo.service.IProfesorService;

@RestController
@RequestMapping(path = "/profesores")
public class ProfesorControllerRestFul {

	@Autowired
	private IProfesorService profesorService;

	// GET:
	// Antes:   http://localhost:8082/API/v1.0/Matricula/profesores/consultarPorId/{id}
	// Despues: http://localhost:8082/API/v1.0/Matricula/profesores/{id}	GET
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	public Profesor consultarPorId(@PathVariable Integer id) {
		return this.profesorService.buscar(id);
	}
	
	// GET para filtrar:
	// Antes:   http://localhost:8082/API/v1.0/Matricula/profesores/consultarTodosPorGenero?genero=M
	// Despues: http://localhost:8082/API/v1.0/Matricula/profesores		GET
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public List<Profesor> consultarTodosPorGenero(@RequestParam(required = true, defaultValue = "M") String genero){
		return this.profesorService.seleccionarTodos(genero);
	}

	// POST: 
	// Antes:   http://localhost:8082/API/v1.0/Matricula/profesores/guardar
	// Despues: http://localhost:8082/API/v1.0/Matricula/profesores		POST
	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
	public void guardar(@RequestBody Profesor profesor) {
		this.profesorService.guardar(profesor);
	}

	// PUT: 
	// Antes:   http://localhost:8082/API/v1.0/Matricula/profesores/actualizar/{id}
	// Despues: http://localhost:8082/API/v1.0/Matricula/profesores/{id}	PUT
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_XML_VALUE)
	public void actualizar(@RequestBody Profesor profesor, @PathVariable Integer id) {
		profesor.setId(id);
		this.profesorService.actualizar(profesor);
	}

	// PATCH: 
	// Antes:    http://localhost:8082/API/v1.0/Matricula/profesores/actualizarParcial
	// Despues:  http://localhost:8082/API/v1.0/Matricula/profesores/{id}	PATCH
	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_XML_VALUE)
	public void actualizarParcial(@RequestBody Profesor profesor, @PathVariable Integer id) {
		profesor.setId(id);
		this.profesorService.actualizarParcial(profesor.getApellido(), profesor.getNombre(), profesor.getId());
	}

	// DELETE: 
	// Antes:  http://localhost:8082/API/v1.0/Matricula/profesores/borrarPorId/{id}
	// Despues:  http://localhost:8082/API/v1.0/Matricula/profesores/{id}
	@DeleteMapping(path = "/{id}")
	public void borrarPorId(@PathVariable Integer id) {
		this.profesorService.borrar(id);
	}
}
