package com.uce.edu.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ventas.repository.IHotelRepository;
import com.uce.edu.ventas.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepository hotelRepository;

	@Override
	public void guardar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.hotelRepository.insertar(hotel);
	}

	@Override
	public List<Hotel> buscarHabitacionesInnerJoin(String nombre) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHabitacionesInnerJoin(nombre);
	}

	@Override
	public List<Hotel> buscarHabitacionesRightJoin(String nombre) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHabitacionesRightJoin(nombre);
	}

	@Override
	public List<Hotel> buscarHabitacionesLeftJoin(String direccion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHabitacionesLeftJoin(direccion);
	}

	@Override
	public List<Hotel> buscarHabitacionesFullJoin(String direccion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHabitacionesFullJoin(direccion);
	}
}
