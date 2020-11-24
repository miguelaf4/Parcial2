package com.mayab.calidad.dao;

public class Alumno {
	
	private int id;
	private String nombre;
	private int edad;
	private int calif;
	private String email;
	
	
	public Alumno(int id, String nombre, int edad, int calif, String email) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.calif = calif;
		this.email = email;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public int getCalif() {
		return calif;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setCalif(int calif) {
		this.calif = calif;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	
}