package com.uce.edu.funcional;

public class PersonaSupplierImpl implements IPersonSupplier<String> {

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		String cedula = "175030";
		cedula = cedula + "provincia";
		return cedula;
	}

}
