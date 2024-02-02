package com.uce.edu.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ventas.repository.IAutorRepository;
import com.uce.edu.ventas.repository.modelo.Autor;

@Service
public class AutorServiceImpl implements IAutorService {

	@Autowired
	private IAutorRepository autorRepository;

	@Override
	public Autor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionar(id);
	}

	@Override
	public void guardar(Autor autor) {
		// TODO Auto-generated method stub
		this.autorRepository.insertar(autor);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.autorRepository.actualizar(autor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.autorRepository.eliminar(id);
	}

	@Override
	public List<Autor> buscarLibrosInnerJoin() {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarLibrosInnerJoin();
	}

	@Override
	public List<Autor> buscarLibrosInnerJoin(String nombre) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarLibrosInnerJoin(nombre);
	}

	@Override
	public List<Autor> buscarLibrosRightJoin() {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarLibrosRightJoin();
	}

	@Override
	public List<Autor> buscarLibrosRightJoin(String nacionalidad) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarLibrosRightJoin(nacionalidad);
	}

	@Override
	public List<Autor> buscarLibrosLeftJoin() {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarLibrosLeftJoin();
	}

	@Override
	public List<Autor> buscarLibrosLeftJoin(String nombre) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarLibrosLeftJoin(nombre);
	}

	@Override
	public List<Autor> buscarLibrosFullJoin() {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarLibrosFullJoin();
	}

	@Override
	public List<Autor> buscarLibrosFullJoin(String nacionalidad) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarLibrosFullJoin(nacionalidad);
	}

	@Override
	public List<Autor> buscarLibrosFetchJoin() {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarLibrosFetchJoin();
	}

	@Override
	public List<Autor> buscarLibrosFetchJoin(String nombre, String nacionalidad) {
		// TODO Auto-generated method stub
		return this.autorRepository.seleccionarLibrosFetchJoin(nombre, nacionalidad);
	}

}
