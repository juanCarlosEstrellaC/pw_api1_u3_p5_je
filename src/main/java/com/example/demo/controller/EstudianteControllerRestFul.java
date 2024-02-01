package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

// API está representado por un proyecto Java				
// El Servicio está representado por una Clase Controller
// Las capacidades está representadas por los Métodos de esa clase controller.

@RestController
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	// GET
	// http://localhost:8082/API/v1.0/Matricula/estudiantes/consultar
	@GetMapping(path = "/consultar")
	public Estudiante consultar() {
		return this.estudianteService.buscar(1);
	}

	// POST
	// http://localhost:8082/API/v1.0/Matricula/estudiantes/guardar
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}
	
	// PUT
	// http://localhost:8082/API/v1.0/Matricula/estudiantes/actualizar
	@PutMapping(path = "/actualizar")
	public void actualizar(@RequestBody Estudiante estudiante) {
		this.estudianteService.actualizar(estudiante);
	}
	
	// PATCH
	// http://localhost:8082/API/v1.0/Matricula/estudiantes/actualizarParcial
	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial(@RequestBody Estudiante estudiante) {
		this.estudianteService.actualizarParcial(estudiante.getApellido(), estudiante.getNombre(), estudiante.getId());
	}
	
	// DELETE
	// http://localhost:8082/API/v1.0/Matricula/estudiantes/borrar
	@DeleteMapping(path = "/borrar")
	public void borrar() {
		this.estudianteService.borrar(8);
	}
	
	
	
	
	
	
	
	
	
}
