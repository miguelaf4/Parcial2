package com.mayab.calidad.doubles;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.HashMap;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;


import com.mayab.calidad.dao.*;


public class TestAlumnoUnit {
	private Alumno alumno;
	private DAOSql database;
	@Before 
	public void setupMocks() {
		database = mock(DAOSql.class);
		alumno = new Alumno(0033,"Miguel", 20, 10, "hola@mail.com");
		
		
		setupDatabase();
		addAlumnos();
	}
	
	public void setupDatabase() {
		when(database.getDatabase()).thenReturn(new HashMap<Integer, Alumno>());
	}
	
	public void addAlumnos() {
		
		when(database.addAlumno(any(Alumno.class))).thenAnswer(new Answer<Boolean>() {
			
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
			 Alumno arg = (Alumno) invocation.getArguments()[0];
			 
		
			 database.getDatabase().putIfAbsent(arg.getId(), arg);
			 return true;
			}
			
		});
		
	}
	
	@Test
	public void testAddAlumnos() {
		
		
		
		
		int size = database.getDatabase().size();
		
		database.addAlumno(alumno);
		
		
		assertThat(database.getDatabase().size(), is(size + 1));
	}
	
	@Test
	public void testDeleteAlumno() {
		
		when(database.deleteAlumno(any(Alumno.class))).thenAnswer(new Answer<Boolean>() {
			
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
			 Alumno arg = (Alumno) invocation.getArguments()[0];
			 
			 if(database.getDatabase().containsKey(arg.getId())) {
				 database.getDatabase().remove(arg.getId());
				 return true;
			 }
			 
			 	return false;
			}
			
		});
		
	
		
		database.addAlumno(alumno);
		int size = database.getDatabase().size();
		database.deleteAlumno(alumno);
		
		assertThat(database.getDatabase().size(), is(size - 1));
	}
	
	@Test
	public void testUpdateAlumno() {
		
		when(database.updateAlumnoCalif(any(Alumno.class), anyInt())).thenAnswer(new Answer<Boolean>() {
			
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
			 Alumno arg = (Alumno) invocation.getArguments()[0];
			 int arg1 = (Integer) invocation.getArguments()[1];
			 
			 if(database.getDatabase().containsKey(arg.getId())) {
				 Alumno alumno = database.getDatabase().get(arg.getId());
				 alumno.setCalif(arg1);
				 database.getDatabase().put(alumno.getId(), alumno);	 
				 return true;
			 }
			 
			 
			 	return false;
			}
			
		});
		
	
		
		database.addAlumno(alumno);
		int cal = database.getDatabase().get(alumno.getId()).getCalif();
		database.updateAlumnoCalif(alumno, 9);
		cal = database.getDatabase().get(alumno.getId()).getCalif();
		
		assertThat(cal, is(alumno.getCalif()));
	}

}

