package com.example.demo.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

public class EstudianteTO extends RepresentationModel<EstudianteTO> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nombre;
	private String apellido;
	private String genero;
	private LocalDateTime fechaNacimiento;
	private String hobby;
	private Integer edad;
	private String estadoCivil;
	private Integer numeroHermanos;
	private String direccion;
	
	// ToString
	@Override
	public String toString() {
		return "EstudianteTO [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero
				+ ", fechaNacimiento=" + fechaNacimiento + ", hobby=" + hobby + ", edad=" + edad + ", estadoCivil="
				+ estadoCivil + ", numeroHermanos=" + numeroHermanos + ", direccion=" + direccion + "]";
	}

	// SET Y GET
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Integer getNumeroHermanos() {
		return numeroHermanos;
	}

	public void setNumeroHermanos(Integer numeroHermanos) {
		this.numeroHermanos = numeroHermanos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
