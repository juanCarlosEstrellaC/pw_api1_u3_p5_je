package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.DTO.EstudianteDTO;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {

	// CRUD + Update Parcial
	public void guardar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public void actualizarParcial(String apellido, String nombre, Integer id);
	public Estudiante buscar(Integer id); //Buscar por ID
	public EstudianteTO buscarTO(Integer id); //Buscar por ID
	public void borrar(Integer id);
	
	public List<Estudiante> seleccionarTodos(String genero);
	public List<EstudianteTO> buscarTodosTO();
	public List<Estudiante> seleccionarTodosSinFiltro();

	public List<EstudianteDTO> seleccionarTodosDTO();

	

}
