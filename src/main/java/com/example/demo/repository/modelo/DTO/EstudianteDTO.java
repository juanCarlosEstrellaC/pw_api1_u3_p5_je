package com.example.demo.repository.modelo.DTO;

import org.springframework.hateoas.RepresentationModel;

public class EstudianteDTO extends RepresentationModel<EstudianteDTO>{


	
	private Integer id;
	private String nombre;

	public EstudianteDTO() {

	}

	public EstudianteDTO(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	// ToString:
	@Override
	public String toString() {
		return "EstudianteDTO [id=" + id + ", nombre=" + nombre + "]";
	}

	// GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
