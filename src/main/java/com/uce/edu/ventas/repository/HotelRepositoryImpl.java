package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public List<Hotel> seleccionarHabitacionesInnerJoin(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> mQ = this.entityManager
				.createQuery("SELECT ho FROM Hotel ho JOIN ho.habitaciones ha WHERE ho.nombre = : nombre", Hotel.class);
		mQ.setParameter("nombre", nombre);
		List<Hotel> lista = mQ.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHabitacionesRightJoin(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> mQ = this.entityManager.createQuery(
				"SELECT ho FROM Hotel ho RIGHT JOIN ho.habitaciones ha WHERE ho.nombre = : nombre", Hotel.class);
		mQ.setParameter("nombre", nombre);
		List<Hotel> lista = mQ.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHabitacionesLeftJoin(String direccion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> mQ = this.entityManager.createQuery(
				"SELECT ho FROM Hotel ho LEFT JOIN ho.habitaciones ha WHERE ho.direccion = : direccion", Hotel.class);
		mQ.setParameter("direccion", direccion);
		List<Hotel> lista = mQ.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHabitacionesFullJoin(String direccion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> mQ = this.entityManager.createQuery(
				"SELECT ho FROM Hotel ho FULL JOIN ho.habitaciones ha WHERE ho.direccion = : direccion", Hotel.class);
		mQ.setParameter("direccion", direccion);
		List<Hotel> lista = mQ.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

}
