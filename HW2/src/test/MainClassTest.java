package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ChicagoData.FileCSVReader;
import ChicagoData.HealthClinic;
import ChicagoData.LifeExpectancy;
import ChicagoData.MainClass;

public class MainClassTest {

	/**
	 * Test for print method
	 */
	@Test
	public void printTest() {
		PrintStream originalOut = System.out;
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);

		List<HealthClinic> newList = new ArrayList<HealthClinic>();
		HealthClinic h = new HealthClinic("a", "b", "c", "d");
		newList.add(h);
		MainClass.print(newList);

		// Perform tests
		assertEquals(
				os.toString()
						.contains(
								"HealthClinic [facility=a,	 community=b,	 phone=c,	 description=d,	 address=null]"),
				true);

		// Restore normal operation
		System.setOut(originalOut);
	}
	
	/**
	 * Test for print method
	 */
	@Test
	public void getCorrelationTest() {

		List<HealthClinic> clinics = new ArrayList<HealthClinic>();
		FileCSVReader.readClinicCsvFile("src/test/Health_clinic_test.csv",
				clinics);
		List<LifeExpectancy> life = new ArrayList<LifeExpectancy>();
		FileCSVReader.readLifeCsvFile("src/test/life_test.csv", clinics, life);
		double ans1 = MainClass.getCorrelation(life).get("2010");
		double ans2 = MainClass.getCorrelation(life).get("2000");
		double ans3 = MainClass.getCorrelation(life).get("1990");
		
		// assert result
		//Result tested with excel formula
		assertEquals(-1.0d, ans1, 0.01);
		assertEquals(-1.0d, ans2, 0.01);
		assertEquals(-0.99d, ans3, 0.01);
	}
	
	/**
	 * Testing Coefficient method
	 */
	@Test
	public void getCoefficientTest() {
		double c = MainClass.getCoefficient(1, 1, 1);
		assertEquals(1.00d, c, 0.01);
	}

	/**
	 * Testing distribution method
	 */
	@Test
	public void getVMRTest() {
		List<HealthClinic> clinics = new ArrayList<HealthClinic>();
		FileCSVReader.readClinicCsvFile("src/test/Health_clinic_test.csv",
				clinics);
		List<LifeExpectancy> life = new ArrayList<LifeExpectancy>();
		FileCSVReader.readLifeCsvFile("src/test/life_test.csv", clinics, life);
		double ans1 = MainClass.getVMR(life);
		
		// assert result
		//Result tested with excel formula
		assertEquals(0.33d, ans1, 0.01);
	}
}
