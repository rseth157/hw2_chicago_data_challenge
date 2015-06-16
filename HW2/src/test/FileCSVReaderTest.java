package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ChicagoData.FileCSVReader;
import ChicagoData.HealthClinic;
import ChicagoData.LifeExpectancy;

public class FileCSVReaderTest {

	/**
	 * test for empty health file
	 */
	@Test
	public void readClinicCsvFileEmptyTest() {
		List<HealthClinic> clinics = new ArrayList<HealthClinic>();
		FileCSVReader.readClinicCsvFile(
				"src/test/Empty_Health_clinic_test.csv", clinics);
		assertEquals(0, clinics.size());
	}

	/**
	 * test for empty life file
	 */
	@Test
	public void readLifeCsvFileEmptyTest() {
		List<HealthClinic> clinics = new ArrayList<HealthClinic>();
		FileCSVReader.readClinicCsvFile(
				"src/test/Empty_Health_clinic_test.csv", clinics);
		List<LifeExpectancy> life = new ArrayList<LifeExpectancy>();
		FileCSVReader.readLifeCsvFile("src/test/Empty_life_test.csv", clinics,
				life);
		assertEquals(0, life.size());
	}

	/**
	 * test for health file data
	 */
	@Test
	public void readClinicCsvFileTest() {
		List<HealthClinic> clinics = new ArrayList<HealthClinic>();
		FileCSVReader.readClinicCsvFile("src/test/Health_clinic_test.csv",
				clinics);
		assertEquals(1, clinics.size());
	}

	/**
	 * test for life file data
	 */
	@Test
	public void readLifeCsvFileTest() {
		List<HealthClinic> clinics = new ArrayList<HealthClinic>();
		FileCSVReader.readClinicCsvFile("src/test/Health_clinic_test.csv",
				clinics);
		List<LifeExpectancy> life = new ArrayList<LifeExpectancy>();
		FileCSVReader.readLifeCsvFile("src/test/life_test.csv", clinics, life);
		assertEquals(1, clinics.size());
		assertEquals(1, life.size());
	}

	/**
	 * test for health file data accuracy
	 */
	@Test
	public void readClinicCsvFileDataTest() {
		List<HealthClinic> clinics = new ArrayList<HealthClinic>();
		FileCSVReader.readClinicCsvFile("src/test/Health_clinic_test.csv",
				clinics);
		assertEquals(1, clinics.size());
		assertEquals("Erie Family Health Center -- Helping Hands",
				clinics.get(0).getFacilty());
		assertEquals("Rogers Park (1)", clinics.get(0).getCommunity());
		assertEquals(null, clinics.get(0).getAddress());
		assertEquals("FQHC", clinics.get(0).getDescription());
	}

	/**
	 * test for life file data accuracy
	 */
	@Test
	public void readLifeCsvFileDataTest() {
		List<HealthClinic> clinics = new ArrayList<HealthClinic>();
		FileCSVReader.readClinicCsvFile("src/test/Health_clinic_test.csv",
				clinics);
		List<LifeExpectancy> life = new ArrayList<LifeExpectancy>();
		FileCSVReader.readLifeCsvFile("src/test/life_test.csv", clinics, life);
		assertEquals(1, life.get(0).getCommunityNumber());
		assertEquals("Rogers Park", life.get(0).getCommunity());
		assertEquals(77.30d, life.get(0).getLifeExpectency2010(), 0.01);
		assertEquals(73.09d, life.get(0).getLifeExpectency2000(), 0.01);
		assertEquals(70.90d, life.get(0).getLifeExpectency1990(), 0.01);
	}

	/**
	 * Test the number of clinics in the area
	 */
	@Test
	public void readLifeCsvFileClinicTest() {
		List<HealthClinic> clinics = new ArrayList<HealthClinic>();
		FileCSVReader.readClinicCsvFile("src/test/Health_clinic_test.csv",
				clinics);
		List<LifeExpectancy> life = new ArrayList<LifeExpectancy>();
		FileCSVReader.readLifeCsvFile("src/test/life_test.csv", clinics, life);
		assertEquals(1, life.get(0).getCommunityNumber());
		assertEquals("Rogers Park", life.get(0).getCommunity());
		assertEquals(77.30d, life.get(0).getLifeExpectency2010(), 0.01);
		assertEquals(73.09d, life.get(0).getLifeExpectency2000(), 0.01);
		assertEquals(70.90d, life.get(0).getLifeExpectency1990(), 0.01);
		assertEquals(1.0f, life.get(0).getNumberOfClinics(), 1.0);
	}

	/**
	 * test for toString Method
	 */
	@Test
	public void lifeDataToStringTest() {
		List<HealthClinic> clinics = new ArrayList<HealthClinic>();
		FileCSVReader.readClinicCsvFile("src/test/Health_clinic_test.csv",
				clinics);
		List<LifeExpectancy> life = new ArrayList<LifeExpectancy>();
		FileCSVReader.readLifeCsvFile("src/test/life_test.csv", clinics, life);
		assertEquals(
				"Life Expectency [Community Number=1,	 Community=Rogers Park,	 Number Of Health Clinics=0.0,	 Life Expectency in 2000=73.1,	 Life Expectency in 2010=77.3]",
				life.get(0).toString());
	}
	
	@Test
	public void clinicDataToStringTest() {
		List<HealthClinic> clinics = new ArrayList<HealthClinic>();
		FileCSVReader.readClinicCsvFile("src/test/Health_clinic_test.csv",
				clinics);;
		assertEquals(
				"HealthClinic [facility=Erie Family Health Center -- Helping Hands, community=Rogers Park (1), phone=(312) 666-3494, description=FQHC, address=null]",
				clinics.get(0).toString());
	}

}
