package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;
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
		System.out.println("UPDATE");

		int cantidad = this.facturaService.actualizarFechas(LocalDateTime.of(2020, 1, 15, 12, 50),
				LocalDateTime.of(2024, 1, 1, 0, 0, 0));
		System.out.println("cantidad de registros/filas actualizados: ");
		System.out.println(cantidad);

		System.out.println("DELETE");
		int c1 = this.facturaService.borrarPorNumero("0001-02570");
		System.out.println("cantidad de registros/filas eliminados: ");
		System.out.println(c1);

		// this.facturaService.eliminar(1);

		System.out.println("DTO");
		List<FacturaDTO> listaDTO = this.facturaService.buscarFacturasDTO();
		for (FacturaDTO fDto : listaDTO) {
			System.out.println(fDto);
		}
	}

}
