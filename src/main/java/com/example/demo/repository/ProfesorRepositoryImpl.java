package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Profesor;

@Repository
@Transactional
public class ProfesorRepositoryImpl implements IProfesorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Profesor profesor) {
		this.entityManager.persist(profesor);
	}

	@Override
	public void actualizar(Profesor profesor) {
		this.entityManager.merge(profesor);
	}

	@Override
	public void actualizarParcial(String apellido, String nombre, Integer id) {
		Query query = this.entityManager
				.createQuery("UPDATE Profesor p SET p.nombre = :valor1, p.apellido=:valor2 WHERE p.id=:valor3");
		query.setParameter("valor1", nombre);
		query.setParameter("valor2", apellido);
		query.setParameter("valor3", id);
		query.executeUpdate(); // este puede retornar un entero con el número de actualizaciones hechas.
	}

	@Override
	public Profesor seleccionar(Integer id) { // Buscar por ID
		return this.entityManager.find(Profesor.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public List<Profesor> seleccionarTodos(String genero) {
		TypedQuery<Profesor> myQuery = this.entityManager
				.createQuery("SELECT p FROM Profesor p WHERE p.genero = :variable ", Profesor.class);
		myQuery.setParameter("variable", genero);
		return myQuery.getResultList();
	}

}
