package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.DTO.EstudianteDTO;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void guardar(EstudianteTO estudianteTO) {
		Estudiante e = this.convertirTOaEstudiante(estudianteTO);
		System.out.println(e);
		this.estudianteRepository.insertar(e);
	}

	@Override
	public void actualizar(EstudianteTO estudianteTO) {
		Estudiante e = this.convertirTOaEstudiante(estudianteTO);
		this.estudianteRepository.actualizar(e);
	}

	@Override
	public void actualizarParcial(String apellido, String nombre, Integer id) {
		this.estudianteRepository.actualizarParcial(apellido, nombre, id);
	}

	@Override
	public Estudiante buscar(Integer id) {
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.estudianteRepository.eliminar(id);
	}

	@Override
	public List<Estudiante> seleccionarTodos(String genero) {
		return this.estudianteRepository.seleccionarTodos(genero);
	}

	@Override
	public List<EstudianteTO> buscarTodosTO() {
		// List<Estudiante> lista = this.estudianteRepository.seleccionarTodos("M");

		List<Estudiante> lista = this.estudianteRepository.seleccionarTodosSinFiltro();
		List<EstudianteTO> listaFinal = new ArrayList<>();
		for (Estudiante est : lista) {
			listaFinal.add(this.convertir(est));
		}
		return listaFinal;
	}

	private EstudianteTO convertir(Estudiante est) {
		EstudianteTO estuTO = new EstudianteTO();
		estuTO.setId(est.getId());
		estuTO.setNombre(est.getNombre());
		estuTO.setApellido(est.getApellido());
		estuTO.setGenero(est.getGenero());
		estuTO.setFechaNacimiento(est.getFechaNacimiento());
		estuTO.setEdad(est.getEdad());
		estuTO.setDireccion(est.getDireccion());
		estuTO.setEstadoCivil(est.getEstadoCivil());
		estuTO.setHobby(est.getHobby());
		estuTO.setNumeroHermanos(est.getNumeroHermanos());
		return estuTO;
	}

	private Estudiante convertirTOaEstudiante(EstudianteTO estuTO) {
		Estudiante estu = new Estudiante();
		estu.setId(estuTO.getId());
		estu.setNombre(estuTO.getNombre());
		estu.setApellido(estuTO.getApellido());
		estu.setGenero(estuTO.getGenero());
		estu.setFechaNacimiento(estuTO.getFechaNacimiento());
		estu.setEdad(estuTO.getEdad());
		estu.setDireccion(estuTO.getDireccion());
		estu.setEstadoCivil(estuTO.getEstadoCivil());
		estu.setHobby(estuTO.getHobby());
		estu.setNumeroHermanos(estuTO.getNumeroHermanos());
		return estu;
	}

	@Override
	public EstudianteTO buscarTO(Integer id) {
		return this.convertir(this.estudianteRepository.seleccionar(id));
	}

	@Override
	public List<Estudiante> seleccionarTodosSinFiltro() {
		return this.estudianteRepository.seleccionarTodosSinFiltro();
	}

	@Override
	public List<EstudianteDTO> seleccionarTodosDTO() {
		return this.estudianteRepository.seleccionarTodosDTO();
	}

}
