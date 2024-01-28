package com.uce.edu.ventas.repository;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Hotel;

public interface IHotelRepository {

	public void insertar(Hotel hotel);

	public List<Hotel> seleccionarHabitacionesInnerJoin(String nombre);

	public List<Hotel> seleccionarHabitacionesRightJoin(String nombre);

	public List<Hotel> seleccionarHabitacionesLeftJoin(String direccion);

	public List<Hotel> seleccionarHabitacionesFullJoin(String direccion);

}
