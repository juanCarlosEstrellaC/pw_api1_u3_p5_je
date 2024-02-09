package com.example.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.example.demo.repository.modelo.Estudiante;

public class MateriaTO extends RepresentationModel<MateriaTO> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombre;

	private Integer creditos;


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

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
