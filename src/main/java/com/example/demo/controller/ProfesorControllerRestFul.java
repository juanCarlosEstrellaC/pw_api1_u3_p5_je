package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Profesor;
import com.example.demo.service.IProfesorService;

@RestController
@RequestMapping(path = "/profesores")
public class ProfesorControllerRestFul {

	@Autowired
	private IProfesorService profesorService;

	// GET: http://localhost:8082/API/v1.0/Matricula/profesores/consultarPorId/{id}
	@GetMapping(path = "/consultarPorId/{id}")
	public Profesor consultarPorId(@PathVariable Integer id) {
		return this.profesorService.buscar(id);
	}

	// POST: http://localhost:8082/API/v1.0/Matricula/profesores/guardar
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Profesor profesor) {
		this.profesorService.guardar(profesor);
	}

	// PUT: http://localhost:8082/API/v1.0/Matricula/profesores/actualizar
	@PutMapping(path = "/actualizar")
	public void actualizar(@RequestBody Profesor profesor) {
		this.profesorService.actualizar(profesor);
	}

	// PATCH: http://localhost:8082/API/v1.0/Matricula/profesores/actualizarParcial
	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial(@RequestBody Profesor profesor) {
		this.profesorService.actualizarParcial(profesor.getApellido(), profesor.getNombre(), profesor.getId());
	}
}
