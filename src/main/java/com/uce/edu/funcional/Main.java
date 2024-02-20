package com.uce.edu.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Supplier
		System.out.println("************************ SUPPLIER ************************");
		// Clases
		System.out.println("Clases: ");
		IPersonSupplier<String> supplierClase = new PersonaSupplierImpl();
		System.out.println(supplierClase.getId());

		// Lambdas
		System.out.println("Lambdas");
		// "no recibe ningun argumento se representa mediante un parentesis vacio"
		IPersonSupplier<String> supplierLambda = () -> {
			String cedula = "175030";
			cedula = cedula + "canton";
			return cedula;
		};
		System.out.println(supplierLambda.getId());

		IPersonSupplier<String> supplierLambda2 = () -> "175030" + "pais";
		System.out.println(supplierLambda2.getId());

		IPersonSupplier<Integer> supplierLambda3 = () -> {
			Integer v1 = Integer.valueOf(100);
			v1 = v1 * Integer.valueOf(50) / Integer.valueOf(5);
			return v1;
		};
		System.out.println(supplierLambda3.getId());

		// Métodos referenciados
		System.out.println("Métodos referenciados");
		MetodosReferenciados met = new MetodosReferenciados();
		IPersonSupplier<String> suplierLambda4 = met::obtenerId;
		System.out.println(suplierLambda4.getId());

		// 2. Consumer
		System.out.println("************************ CONSUMER ************************");
		// Clases
		System.out.println("Clases");
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");

		// Lambdas
		System.out.println("Lambdas");
		// "entre parentesis puedo poner cualquier nombre, el tipo de dato ya esta
		// especificado entre <>"
		// "puedo omitir los parentesis pq solo es un dato"
		IPersonaConsumer<String> consumerLambda = cadena -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("Profesor");

		// Metodos referenciados
		System.out.println("Métodos referenciados");
		IPersonaConsumer<String> consumer2 = met::procesar;
		consumer2.accept("Andres referenciado");

		// 3. Predicate
		System.out.println("************************ PREDICATE ************************");
		// Lambdas
		System.out.println("Lambdas");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(8)));

		IPersonaPredicate<String> predicateLambda2 = letra -> "Ctrian".contains(letra);
		System.out.println(predicateLambda2.evaluar("c"));

		// Metodos referenciados
		System.out.println("Métodos referenciados");
		IPersonaPredicate<String> predicate2 = met::evaluar;
		System.out.println(predicate2.evaluar("C"));

		IPersonaPredicate<Integer> predicate3 = met::evaluar;
		System.out.println(predicate3.evaluar(8));

		// 4. Fuction
		System.out.println("************************ FUNCTION ************************");
		// Lambdas
		System.out.println("Lambdas");
		// retorna un string recibe un integer
		IPersonaFunction<String, Integer> functionLambda = numero -> {
			numero = numero + Integer.valueOf(10);
			String numeroString = numero.toString().concat(" - valor");
			return numeroString;
		};
		System.out.println(functionLambda.aplicar(7));

		IPersonaFunction<Empleado, Ciudadano> functionLambda1 = ciudadano -> {
			Empleado e1 = new Empleado();
			e1.setNombreCompleto(ciudadano.getNombre() + " " + ciudadano.getApellido());
			if (ciudadano.getProvincia().compareTo("Pichincha") == 0) {
				e1.setPais("Ecuador");
			}
			return e1;
		};

		Ciudadano c1 = new Ciudadano();
		c1.setApellido("Oli");
		c1.setNombre("Ctrian");
		c1.setProvincia("Pichincha");
		Empleado empl = functionLambda1.aplicar(c1);

		System.out.println(empl);

		// Metodos referenciados
		System.out.println("Métodos referenciados");
		Empleado empl2 = new Empleado();
		empl2.setNombreCompleto("Daniel Vascones");
		empl2.setPais("Colombia");

		IPersonaFunction<Ciudadano, Empleado> function2 = met::cambiar;
		Ciudadano ciudN = function2.aplicar(empl2);
		System.out.println(ciudN);

		// 5. Unary Operator
		System.out.println("************************ UNARY OPERATOR ************************");
		// Lambdas
		System.out.println("Lambdas");
		IPersonaUnaryOperator<Integer> unaryOperatorLambda = numero -> numero + (numero * 2);
		System.out.println(unaryOperatorLambda.aplicar(14));

		IPersonaUnaryOperatorFunction<Integer> unaryOperatorLambda2 = numero -> numero + (numero * 2);
		System.out.println(unaryOperatorLambda2.aplicar(14));

		// Metodos referenciados
		System.out.println("Métodos referenciados");
		IPersonaUnaryOperatorFunction<Empleado> unary3 = met::procesar;
		Empleado emplN = unary3.aplicar(empl2);
		System.out.println(emplN);

		System.out.println(
				"************************ Implementacion de IF mediante librerías Java ************************");
		// 1. Supplier
		System.out.println("Supplier JAVA");
		Stream<String> lista = Stream.generate(() -> "175030" + "pais").limit(20);
		lista.forEach(cadena -> System.out.println(cadena));

		// 2. Consumer
		System.out.println("Consumer JAVA");
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 67, 8, 5, 4, 85, 74);
		listaNumeros.forEach(numero -> {
			System.out.println("Se inserta");
			System.out.println(numero);
		});

		// 3. Predicate
		System.out.println("Predicate JAVA");
		Stream<Integer> listaFiltro = listaNumeros.stream().filter(numero -> numero >= 10);
		listaFiltro.forEach(numero -> System.out.println(numero));

		// 4. Function
		System.out.println("Function JAVA");
		Stream<String> listaCambiada = listaNumeros.stream().map(numero -> {
			numero = numero * 100 / 50;
			return "Num: " + numero.toString();
		});
		listaCambiada.forEach(cadena -> System.out.println(cadena));

		Ciudadano ciud1 = new Ciudadano();
		c1.setApellido("Oli");
		c1.setNombre("Ctrian");
		c1.setProvincia("Pichincha");

		Ciudadano ciud2 = new Ciudadano();
		c1.setApellido("Eduardo");
		c1.setNombre("Landazuri");
		c1.setProvincia("Pichincha");

		Ciudadano ciud3 = new Ciudadano();
		c1.setApellido("Gabriela");
		c1.setNombre("Gallegos");
		c1.setProvincia("Pichincha");

		List<Ciudadano> lCiud = Arrays.asList(ciud1, ciud2, ciud3);
		Stream<Empleado> lEmpl = lCiud.stream().map(ciudadanom -> {
			Empleado em1 = new Empleado();
			em1.setNombreCompleto(ciudadanom.getNombre() + " " + ciudadanom.getApellido());
			if (ciudadanom.getProvincia().compareTo("Pichincha") == 0) {
				em1.setPais("Ecuador");
			}
			return em1;
		});
		lEmpl.forEach(empleado -> System.out.println(empleado));

		System.out.println("Unary Operator JAVA");
		Stream<Integer> listaNumeros2 = listaNumeros.stream().map(numero -> {
			numero = numero * 100 / 50;
			return numero;
		});
		listaNumeros2.forEach(numero -> System.out.println(numero));
	}

}
