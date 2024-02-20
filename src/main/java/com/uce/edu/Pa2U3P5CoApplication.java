package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IClienteService;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5CoApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService facturaService;

	@Autowired
	private IClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5CoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		 * 
		 * long tI = System.currentTimeMillis(); for (int i = 1; i <= 5; i++) { Cliente
		 * cliente = new Cliente(); cliente.setNombre("CN" + i);
		 * cliente.setApellido("CA" + i); this.clienteService.guardar(cliente); } long
		 * tF = System.currentTimeMillis();
		 * 
		 * long tT = (tF - tI) / 1000;
		 * System.out.println("Tiempo transcurrido en segundos: " + tT);
		 */

//		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
//		long tI = System.currentTimeMillis();
//		List<Cliente> lC = new ArrayList<>();
//		for (int i = 1; i <= 100; i++) {
//			Cliente cliente = new Cliente();
//			cliente.setNombre("CN" + i);
//			cliente.setApellido("CA" + i);
//			lC.add(cliente);
//		}
//		lC.stream().forEach(cliente -> this.clienteService.guardar(cliente));
//		long tF = System.currentTimeMillis();
//
//		long tT = (tF - tI) / 1000;
//		System.out.println("Tiempo transcurrido en segundos: " + tT);

		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		long tI = System.currentTimeMillis();
		List<Cliente> lC = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("CN" + i);
			cliente.setApellido("CA" + i);
			lC.add(cliente);
		}
		lC.parallelStream().forEach(cliente -> this.clienteService.guardar(cliente));
		long tF = System.currentTimeMillis();

		long tT = (tF - tI) / 1000;
		System.out.println("Tiempo transcurrido en segundos: " + tT);
	}

}
