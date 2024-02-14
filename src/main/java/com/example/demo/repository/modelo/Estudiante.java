package com.example.demo.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
//@JsonIgnoreProperties(value = "materias")
public class Estudiante {

	@Id
	@GeneratedValue(generator = "seq_estudiante", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_estudiante", sequenceName = "seq_estudiante", allocationSize = 1) 
	@Column(name = "estu_id")
	private Integer id;

	@Column(name = "estu_nombre")
	private String nombre;

	@Column(name = "estu_apellido")
	private String apellido;

	@Column(name = "estu_genero")
	private String genero;

	@Column(name = "estu_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;

	@Column(name = "estu_hobby")
	private String hobby;

	@Column(name = "estu_edad")
	private Integer edad;

	@Column(name = "estu_estadoCivil")
	private String estadoCivil;

	@Column(name = "estu_numeroHermanos")
	private Integer numeroHermanos;

	@Column(name = "estu_direccion")
	private String direccion;

	// RELACIONES:
	@OneToMany(mappedBy = "estudiante")
	private List<Materia> materias;

	// ToString:
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero
				+ ", fechaNacimiento=" + fechaNacimiento + ", hobby=" + hobby + ", edad=" + edad + ", estadoCivil="
				+ estadoCivil + ", numeroHermanos=" + numeroHermanos + ", direccion=" + direccion + ", materias="
				+ materias + "]";
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

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
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
//


}
