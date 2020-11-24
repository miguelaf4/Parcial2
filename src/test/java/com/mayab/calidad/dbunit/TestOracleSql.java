package com.mayab.calidad.dbunit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mayab.calidad.dao.*;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import java.io.File;

public class TestOracleSql extends DBTestCase {

	
	public void TestAlumnoOracleSQL(String nombre) {
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "oracle.jdbc.driver.OracleDriver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:oracle:thin:@localhost:1525:xe");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "dbunit");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "dbunit");	
	}
	
	@Before
	public void setUp() throws Exception{
		super.setUp();
		IDatabaseConnection connection = getConnection();
		try {
			DatabaseOperation.CLEAN_INSERT.execute(connection, getDataSet());
		} finally {
			connection.close();
		}
	}
		
	@Test
	public void testInsertCount() {
		
		Alumno alumno = new Alumno(00555, "Pedro", 20, 9, "hola@mail.com");
		DAOOracle dao = new DAOOracle();
		
		IDatabaseConnection connection;
		
		try {
			
			connection = getConnection();
			
			int actualRows = connection.getRowCount("alumno");
			dao.addAlumno(alumno);
			assertEquals(actualRows + 1, connection.getRowCount("alumno"));
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteCount() {
		
		Alumno alumno = new Alumno(00555, "Pedro", 20, 9, "hola@mail.com");
		DAOOracle dao = new DAOOracle();
		
		dao.getAlumno(alumno.getId());
		IDatabaseConnection connection;
		
		try {
			
			connection = getConnection();
			
			int actualRows = connection.getRowCount("alumno");
			dao.deleteAlumno(alumno);
			assertEquals(actualRows - 1, connection.getRowCount("alumno"));
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testGetTotal() {
		
		DAOOracle dao = new DAOOracle();
		
		
		IDatabaseConnection connection;
		
		try {
			
			connection = getConnection();
			
			int actualRows = connection.getRowCount("alumno");
			int expectedResult = dao.getAlumnosTotal();
			assertEquals(actualRows, expectedResult);
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	


}
