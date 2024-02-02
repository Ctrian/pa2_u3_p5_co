package com.uce.edu.ventas.repository;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Autor;

public interface IAutorRepository {
	// CRUD
	public Autor seleccionar(Integer id);

	public void insertar(Autor autor);

	public void actualizar(Autor autor);

	public void eliminar(Integer id);

	// deber12

	public List<Autor> seleccionarLibrosInnerJoin();

	public List<Autor> seleccionarLibrosInnerJoin(String nombre);

	public List<Autor> seleccionarLibrosRightJoin();

	public List<Autor> seleccionarLibrosRightJoin(String nacionalidad);

	public List<Autor> seleccionarLibrosLeftJoin();

	public List<Autor> seleccionarLibrosLeftJoin(String nombre);

	public List<Autor> seleccionarLibrosFullJoin();

	public List<Autor> seleccionarLibrosFullJoin(String nacionalidad);

	public List<Autor> seleccionarLibrosFetchJoin();

	public List<Autor> seleccionarLibrosFetchJoin(String nombre, String nacionalidad);
}
