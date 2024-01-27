package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;


// Una API puede tener muchos controladores
// Para implementar un servicio ... Con una clase controller.

// El servicio = Controller
// API = es un proyecto Java
// Las capacidades son los métodos 

@RestController
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired 
	private IEstudianteService estudianteService;
	
	//GET	
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	@GetMapping(path = "/buscar")
	public Estudiante buscar() {
		return this.estudianteService.buscar(1);
	}
	
	@PostMapping(path = "/guardar")
	public void guardar(Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}
}
