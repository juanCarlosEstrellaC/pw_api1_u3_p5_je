package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProfesorRepository;
import com.example.demo.repository.modelo.Profesor;

@Service
public class ProfesorServiceImpl implements IProfesorService {

	@Autowired
	private IProfesorRepository profesorRepository;

	@Override
	public void guardar(Profesor profesor) {
		this.profesorRepository.insertar(profesor);
	}

	@Override
	public void actualizar(Profesor profesor) {
		this.profesorRepository.actualizar(profesor);
	}

	@Override
	public void actualizarParcial(String apellido, String nombre, Integer id) {
		this.profesorRepository.actualizarParcial(apellido, nombre, id);
	}

	@Override
	public Profesor buscar(Integer id) {
		return this.profesorRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.profesorRepository.eliminar(id);
	}

	@Override
	public List<Profesor> seleccionarTodos(String genero) {
		return this.profesorRepository.seleccionarTodos(genero);
	}

}
