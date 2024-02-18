package com.uce.edu.funcional;

public class MetodosReferenciados {

	public String obtenerId() {
		// TODO Auto-generated method stub
		String cedula = "175030";
		cedula = cedula + " referenciado";
		return cedula;
	}

	public void procesar(String cadena) {
		System.out.println(cadena);
		System.out.println("se proceso la cadena ^^");
	}

	public boolean evaluar(String cadena) {
		System.out.println("Con boolean");
		return "Ctrian".contains(cadena);
	}

	public boolean evaluar(Integer numero) {
		System.out.println("Con integer");
		return 8 == numero;
	}

	public Ciudadano cambiar(Empleado empl) {
		Ciudadano c1 = new Ciudadano();
		String nombre = empl.getNombreCompleto().split(" ")[0];
		String apellido = empl.getNombreCompleto().split(" ")[1];
		c1.setNombre(nombre);
		c1.setApellido(apellido);
		c1.setProvincia("Chimborazo");
		return c1;
	}

	public Empleado procesar(Empleado empl) {
		empl.setNombreCompleto(empl.getNombreCompleto() + " " + empl.getPais());
		empl.setPais(empl.getPais() + " de nacimiento");
		return empl;
	}

}
