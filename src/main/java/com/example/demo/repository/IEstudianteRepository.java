package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.DTO.EstudianteDTO;

public interface IEstudianteRepository {

	// CRUD + Update Parcial
	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public void actualizarParcial(String apellido, String nombre, Integer id);
	public Estudiante seleccionar(Integer id); //Buscar por ID
	public void eliminar(Integer id);
	
	public List<Estudiante> seleccionarTodos(String genero);
	
	public List<Estudiante> seleccionarTodosSinFiltro();
	
	public List<EstudianteDTO> seleccionarTodosDTO();
	
}
