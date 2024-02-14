package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.DTO.EstudianteDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
	}

	@Override
	public void actualizarParcial(String apellido, String nombre, Integer id) {
		// JPQL: objetos y atributos
		// SQL: UPDATE estudiante e SET e.estu_nombre=:valor, e.estu_apellido:valor2 WHERE e.estu_id=:valor3
		Query query = this.entityManager.createQuery("UPDATE Estudiante e SET e.nombre = :valor1, e.apellido=:valor2 WHERE e.id=:valor3");
		query.setParameter("valor1", nombre);
		query.setParameter("valor2", apellido);
		query.setParameter("valor3", id);
		query.executeUpdate(); //este puede retornar un entero con el número de actualizaciones hechas.
	}

	@Override
	public Estudiante seleccionar(Integer id) { // Buscar por ID
		return this.entityManager.find(Estudiante.class, id);
	}

	
	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.seleccionar(id));
	}
	
	@Override
	public List<Estudiante> seleccionarTodos(String genero) {
	    // JPQL: SELECT e FROM Estudiante e
//	    Query query = this.entityManager.createQuery("SELECT e FROM Estudiante e");
//	    return query.getResultList();
		
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.genero = :variable ", Estudiante.class);
		myQuery.setParameter("variable", genero);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> seleccionarTodosSinFiltro() {
		Query q = this.entityManager.createQuery("SELECT e FROM Estudiante e");
		return q.getResultList();
	}

	@Override
	public List<EstudianteDTO> seleccionarTodosDTO() {
		Query q = this.entityManager
				.createQuery("SELECT NEW com.example.demo.repository.modelo.DTO.EstudianteDTO(e.id, e.nombre) FROM Estudiante e");
		return q.getResultList();
	}


}
