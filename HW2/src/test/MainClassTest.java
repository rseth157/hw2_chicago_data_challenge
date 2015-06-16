package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ChicagoData.HealthClinic;
import ChicagoData.MainClass;

public class MainClassTest {

	@Test
	public void getCoefficientTest() {
		// fail("Not yet implemented");
		double c = MainClass.getCoefficient(1, 1, 1);
		assertEquals(1.00d, c, 0.01);
	}

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
		String separator = System.getProperty("line.separator");
		assertEquals(
				os.toString()
						.contains(
								"HealthClinic [facility=a, community=b, phone=c, description=d, address=null]"),
				true);

		// Restore normal operation
		System.setOut(originalOut);
	}

}
