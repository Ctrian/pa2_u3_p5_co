package com.uce.edu;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5CoApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5CoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// Existe una transaccion activa? O: false
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

		Factura factura = new Factura();
		factura.setCedula("1712");
		factura.setFecha(LocalDateTime.now());
		factura.setNumero("001-0010");
		
		Cliente cliente = new Cliente();
		cliente.setNombre("Carlos");
		cliente.setApellido(null);
		
		this.facturaService.guardar(factura, cliente);
	}

}
