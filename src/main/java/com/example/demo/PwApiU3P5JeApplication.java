package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.IEstudianteService;
import com.example.demo.service.to.EstudianteTO;

@SpringBootApplication
public class PwApiU3P5JeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PwApiU3P5JeApplication.class, args);
	}

	@Autowired
	private IEstudianteService estudianteService;
	
	@Override
	public void run(String... args) throws Exception {
		
		
//		EstudianteTO eto = new EstudianteTO();
//		eto.setApellido("Andrando");
//		eto.setNombre("asm");
//		eto.setId(515);
//		
//		this.estudianteService.guardar(eto);
	}

}
