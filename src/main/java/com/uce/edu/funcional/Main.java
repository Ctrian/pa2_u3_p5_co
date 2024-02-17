package com.uce.edu.funcional;

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

		// 3. Predicate
		System.out.println("************************ PREDICATE ************************");
		// Lambdas
		System.out.println("Lambdas");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(8)));

		IPersonaPredicate<String> predicateLambda2 = letra -> "Ctrian".contains(letra);
		System.out.println(predicateLambda2.evaluar("c"));
	}

}
