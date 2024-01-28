package com.uce.edu.ventas.service;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Hotel;

public interface IHotelService {

	public void guardar(Hotel hotel);

	public List<Hotel> buscarHabitacionesInnerJoin(String nombre);

	public List<Hotel> buscarHabitacionesRightJoin(String nombre);

	public List<Hotel> buscarHabitacionesLeftJoin(String direccion);

	public List<Hotel> buscarHabitacionesFullJoin(String direccion);
}
