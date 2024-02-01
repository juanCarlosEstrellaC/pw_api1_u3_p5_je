package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	// GET
	// http://localhost:8082/API/v1.0/Matricula/estudiantes/consultar/{id}
	@GetMapping(path = "/consultar/{id}")
	public Estudiante consultar(@PathVariable Integer id) {
		return this.estudianteService.buscar(id);
	}
	
	// GET y filtrar
	// http://localhost:8082/API/v1.0/Matricula/estudiantes/consultarTodos?genero=M&edad=100
	@GetMapping(path = "/consultarTodos")
	public List<Estudiante> consultarTodos(@RequestParam String genero, @RequestParam Integer edad) {
		System.out.println(edad);
		return this.estudianteService.seleccionarTodos(genero);
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
	// http://localhost:8082/API/v1.0/Matricula/estudiantes/borrar/{id}
	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		this.estudianteService.borrar(id);
	}
	

	
	
	

	
}
