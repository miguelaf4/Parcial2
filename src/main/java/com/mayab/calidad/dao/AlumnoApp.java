package com.mayab.calidad.dao;

public class AlumnoApp {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alumno alumno = new Alumno(00343, "Miguel", 20, 10, "hola@mail.com");
		DAOOracle oracle = new DAOOracle();
		
		oracle.addAlumno(alumno);
		System.out.println(oracle.getAlumnosTotal());
	}
	
	
	
}