package com.mayab.calidad.doubles;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;



public class TestDependency {
	
	private Dependency dependency;
	
	@Before
	public void setupMocks() {
		dependency = mock(Dependency.class);
	}
	/*
	@Test
	public void test() {
		when(dependency.getClassName()).thenReturn("Mi Nombre");
		
		assertThat(dependency.getClassName(),is("Mi Nombre"));
		assertNull(dependency.getClassName());
		assertNull(dependency.getClassNameUpperCase());
		assertNull(dependency.getSubdependencyClassName());

	}
	*/
	
	@Test
	public void OtroTest() {
		when(dependency.getClassName()).thenReturn("OtroNombre");
		assertThat(dependency.getClassName(), is("OtroNombre"));
	}
	
	@Test
	public void testDependency() {
		when (dependency.getClassName()).thenReturn("hi there");
		assertEquals("hi there", dependency.getClassName());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testException() {
		when(dependency.getClassName()).thenThrow(IllegalArgumentException.class);
		dependency.getClassName();
	}
	
	@Test
	public void testAddTwo () {
		when(dependency.addTwo(1)).thenReturn(5);
		assertEquals(5, dependency.addTwo(1));
		assertEquals(0, dependency.addTwo(27));
	}
	
	@Test
	public void testAnswer() {
		when(dependency.addTwo(anyInt())).thenAnswer(new Answer<Integer>() {
			
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				int arg = (Integer) invocation.getArguments()[0];
				return arg + 20;
			}
			
		});
		assertEquals(30, dependency.addTwo(10));
	}
	
	

}
