package com.uce.edu.ventas.service;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Autor;

public interface IAutorService {
	// CRUD
	public Autor buscar(Integer id);

	public void guardar(Autor autor);

	public void actualizar(Autor autor);

	public void eliminar(Integer id);

	// deber12

	public List<Autor> buscarLibrosInnerJoin();

	public List<Autor> buscarLibrosInnerJoin(String nombre);

	public List<Autor> buscarLibrosRightJoin();

	public List<Autor> buscarLibrosRightJoin(String nacionalidad);

	public List<Autor> buscarLibrosLeftJoin();

	public List<Autor> buscarLibrosLeftJoin(String nombre);

	public List<Autor> buscarLibrosFullJoin();

	public List<Autor> buscarLibrosFullJoin(String nacionalidad);

	public List<Autor> buscarLibrosFetchJoin();

	public List<Autor> buscarLibrosFetchJoin(String nombre, String nacionalidad);
}
