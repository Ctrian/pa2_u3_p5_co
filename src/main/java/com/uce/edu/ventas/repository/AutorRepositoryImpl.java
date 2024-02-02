package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AutorRepositoryImpl implements IAutorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Autor seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Autor.class, id);
	}

	@Override
	public void insertar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(autor);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(autor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Autor autor = this.seleccionar(id);
		this.entityManager.remove(autor);
	}

	@Override
	public List<Autor> seleccionarLibrosInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Autor> mQ = this.entityManager.createQuery("SELECT a FROM Autor a JOIN a.libros", Autor.class);
		List<Autor> lista = mQ.getResultList();
		for (Autor autor : lista) {
			autor.getLibros().size();
		}
		return lista;
	}

	@Override
	public List<Autor> seleccionarLibrosInnerJoin(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Autor> mQ = this.entityManager
				.createQuery("SELECT a FROM Autor a JOIN a.libros l WHERE a.nombre = : nombre", Autor.class);
		mQ.setParameter("nombre", nombre);
		List<Autor> lista = mQ.getResultList();
		for (Autor a : lista) {
			a.getLibros().size();
		}
		return lista;
	}

	@Override
	public List<Autor> seleccionarLibrosRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Autor> mQ = this.entityManager.createQuery("SELECT a FROM Autor a RIGHT JOIN a.libros", Autor.class);
		List<Autor> lista = mQ.getResultList();
		for (Autor autor : lista) {
			autor.getLibros().size();
		}
		return lista;
	}

	@Override
	public List<Autor> seleccionarLibrosRightJoin(String nacionalidad) {
		// TODO Auto-generated method stub
		TypedQuery<Autor> mQ = this.entityManager.createQuery(
				"SELECT a FROM Autor a RIGHT JOIN a.libros l WHERE a.nacionalidad = : nacionalidad", Autor.class);
		mQ.setParameter("nacionalidad", nacionalidad);
		List<Autor> lista = mQ.getResultList();
		for (Autor a : lista) {
			a.getLibros().size();
		}
		return lista;
	}

	@Override
	public List<Autor> seleccionarLibrosLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Autor> mQ = this.entityManager.createQuery("SELECT a FROM Autor a LEFT JOIN a.libros", Autor.class);
		List<Autor> lista = mQ.getResultList();
		for (Autor autor : lista) {
			autor.getLibros().size();
		}
		return lista;
	}

	@Override
	public List<Autor> seleccionarLibrosLeftJoin(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Autor> mQ = this.entityManager
				.createQuery("SELECT a FROM Autor a LEFT JOIN a.libros l WHERE a.nombre = : nombre", Autor.class);
		mQ.setParameter("nombre", nombre);
		List<Autor> lista = mQ.getResultList();
		for (Autor a : lista) {
			a.getLibros().size();
		}
		return lista;
	}

	@Override
	public List<Autor> seleccionarLibrosFullJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Autor> mQ = this.entityManager.createQuery("SELECT a FROM Autor a FULL JOIN a.libros l",
				Autor.class);
		List<Autor> lista = mQ.getResultList();
		for (Autor autor : lista) {
			autor.getLibros().size();
		}
		return lista;
	}

	@Override
	public List<Autor> seleccionarLibrosFullJoin(String nacionalidad) {
		// TODO Auto-generated method stub
		TypedQuery<Autor> mQ = this.entityManager.createQuery(
				"SELECT a FROM Autor a FULL JOIN a.libros l WHERE a.nacionalidad = : nacionalidad", Autor.class);
		mQ.setParameter("nacionalidad", nacionalidad);
		List<Autor> lista = mQ.getResultList();
		for (Autor a : lista) {
			a.getLibros().size();
		}
		return lista;
	}

	@Override
	public List<Autor> seleccionarLibrosFetchJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Autor> mQ = this.entityManager.createQuery("SELECT a FROM Autor a JOIN FETCH a.libros l",
				Autor.class);
		return mQ.getResultList();
	}

	@Override
	public List<Autor> seleccionarLibrosFetchJoin(String nombre, String nacionalidad) {
		// TODO Auto-generated method stub
		TypedQuery<Autor> mQ = this.entityManager.createQuery("SELECT a FROM Autor a JOIN FETCH a.libros l WHERE a.nombre =: nombre AND a.nacionalidad =: nacionalidad", Autor.class);
		mQ.setParameter("nombre", nombre);
		mQ.setParameter("nacionalidad", nacionalidad);
		return mQ.getResultList();
	}

}
