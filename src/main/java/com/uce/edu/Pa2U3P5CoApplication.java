package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.Habitacion;
import com.uce.edu.ventas.repository.modelo.Hotel;
import com.uce.edu.ventas.service.IHotelService;

@SpringBootApplication
public class Pa2U3P5CoApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5CoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Hotel hotel1 = new Hotel();
		hotel1.setNombre("Hilton");
		hotel1.setDireccion("6 de Diciembre");

		Habitacion habitacion1 = new Habitacion();
		habitacion1.setNumero("001");
		habitacion1.setClase("Normal");
		habitacion1.setHotel(hotel1);

		Habitacion habitacion2 = new Habitacion();
		habitacion2.setNumero("002");
		habitacion2.setClase("Economica");
		habitacion2.setHotel(hotel1);

		Habitacion habitacion3 = new Habitacion();
		habitacion3.setNumero("003");
		habitacion3.setClase("Ejecutiva");
		habitacion3.setHotel(hotel1);

		List<Habitacion> lista = new ArrayList<Habitacion>();
		lista.add(habitacion1);
		lista.add(habitacion2);
		lista.add(habitacion3);

		hotel1.setHabitaciones(lista);

		this.hotelService.guardar(hotel1);

		Hotel hotel2 = new Hotel();
		hotel2.setNombre("America");
		hotel2.setDireccion("4 de Agosto");

		this.hotelService.guardar(hotel2);

		Hotel hotel3 = new Hotel();
		hotel3.setNombre("Ghost");
		hotel3.setDireccion("Via San Jose");

		Habitacion habitacion4 = new Habitacion();
		habitacion4.setNumero("B13");
		habitacion4.setClase("Normal");
		habitacion4.setHotel(hotel3);

		List<Habitacion> lista2 = new ArrayList<Habitacion>();
		lista2.add(habitacion4);

		hotel3.setHabitaciones(lista2);

		this.hotelService.guardar(hotel3);

		System.out.println("INNER JOIN");
		List<Hotel> h1 = this.hotelService.buscarHabitacionesInnerJoin("Ghost");
		for (Hotel h : h1) {
			System.out.println(h);
		}

		System.out.println("RIGHT JOIN");
		List<Hotel> h2 = this.hotelService.buscarHabitacionesRightJoin("Hilton");
		for (Hotel h : h2) {
			System.out.println(h);
		}

		System.out.println("LEFT JOIN");
		List<Hotel> h3 = this.hotelService.buscarHabitacionesLeftJoin("4 de Agosto");
		for (Hotel h : h3) {
			System.out.println(h);
		}

		System.out.println("FULL JOIN");
		List<Hotel> h4 = this.hotelService.buscarHabitacionesFullJoin("Via San Jose");
		for (Hotel h : h4) {
			System.out.println(h);
		}

	}

}
