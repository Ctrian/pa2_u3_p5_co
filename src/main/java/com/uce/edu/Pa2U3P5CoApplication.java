package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.Autor;
import com.uce.edu.ventas.service.IAutorService;

@SpringBootApplication
public class Pa2U3P5CoApplication implements CommandLineRunner {

	@Autowired
	private IAutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5CoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--- 2 INNER JOIN ---");
		List<Autor> l1 = this.autorService.buscarLibrosInnerJoin();
		for (Autor a : l1) {
			System.out.println(a);
		}
		System.out.println("------------------------------");
		List<Autor> l2 = this.autorService.buscarLibrosInnerJoin("Carmen");
		for (Autor a : l2) {
			System.out.println(a);
		}

		System.out.println("--- 2 RIGHT JOIN ---");
		List<Autor> l3 = this.autorService.buscarLibrosRightJoin();
		for (Autor a : l3) {
			System.out.println(a);
		}
		System.out.println("------------------------------");
		List<Autor> l4 = this.autorService.buscarLibrosRightJoin("Austriaco");
		for (Autor a : l4) {
			System.out.println(a);
		}

		System.out.println("--- 2 LEFT JOIN ---");
		List<Autor> l5 = this.autorService.buscarLibrosLeftJoin();
		for (Autor a : l5) {
			System.out.println(a);
		}
		System.out.println("------------------------------");
		List<Autor> l6 = this.autorService.buscarLibrosLeftJoin("Carmen");
		for (Autor a : l6) {
			System.out.println(a);
		}

		System.out.println("--- 2 FULL JOIN ---");
		List<Autor> l7 = this.autorService.buscarLibrosFullJoin();
		for (Autor a : l7) {
			System.out.println(a);
		}
		System.out.println("------------------------------");
		List<Autor> l8 = this.autorService.buscarLibrosFullJoin("Colombiana");
		for (Autor a : l8) {
			System.out.println(a);
		}

		System.out.println("--- 2 FETCH JOIN ---");
		List<Autor> l9 = this.autorService.buscarLibrosFetchJoin();
		for (Autor a : l9) {
			System.out.println(a);
		}
		System.out.println("------------------------------");
		List<Autor> l10 = this.autorService.buscarLibrosFetchJoin("Benjamin", "Austriaco");
		for (Autor a : l10) {
			System.out.println(a);
		}
	}

}
