package com.uce.edu.funcional;

@FunctionalInterface
public interface IPersonaFunction<R, T> {
	public T aplicar(R arg);
}
