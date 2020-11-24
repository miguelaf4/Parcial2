package com.mayab.calidad.dao;

public interface DAO {
	public boolean addAlumno(Alumno a);
	
	public boolean deleteAlumno(Alumno a);
	
	public int getAlumnosTotal();
	
	public Alumno getAlumno(int id);
	
	public boolean updateAlumnoCalif(Alumno a, int calif);
	
}
