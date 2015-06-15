import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Richa
 *
 */
public class CsvFileReader {

	// Delimiter used in file
	private static final String COMMA_DELIMITER = ",";

	// HealthClinic attributes index
	private static final int FACILITY_IDX = 0;
	private static final int COMMUNITY_IDX = 1;
	private static final int DESCRIPTION_IDX = 3;
	private static final int PHONE_IDX = 2;
	//private static final int ADDRESS_IDX = 4;
	private static final int COMMUNITYID_IDX = 0;
	private static final int COMMUNITYNAME_IDX = 1;
	private static final int LIFE1999_IDX = 2;
	private static final int LIFE1999L_IDX = 3;
	private static final int LIFE1999UP_IDX = 4;
	private static final int LIFE2000_IDX = 5;
	private static final int LIFE2000L_IDX = 6;
	private static final int LIFE2000UP_IDX = 7;
	private static final int LIFE2010_IDX = 8;
	private static final int LIFE2010L_IDX = 9;
	private static final int LIFE2010UP_IDX = 5;
	
	public static void readClinicCsvFile(String fileName) {

		BufferedReader fileReader = null;
		try {

			// Create a new list of clinics to be filled by CSV file data
			List<HealthClinic> Clinics = new ArrayList<HealthClinic>();

			String line = "";

			// Create the file reader
			fileReader = new BufferedReader(new FileReader(fileName));

			// Read the CSV file header to skip it
			fileReader.readLine();

			// Read the file line by line starting from the second line
			while ((line = fileReader.readLine()) != null) {
				// Get all tokens available in line
				String[] tokens = line.split(COMMA_DELIMITER);
				if (tokens.length > 0) {
					// Create a new Clinic object and fill data
					HealthClinic clinic = new HealthClinic(
							tokens[FACILITY_IDX], tokens[COMMUNITY_IDX],
							tokens[PHONE_IDX], tokens[DESCRIPTION_IDX]/*
																	 * , tokens[
																	 * ADDRESS_IDX
																	 * ]
																	 */);
					Clinics.add(clinic);
				}
			}

			System.out.println("total records = " + Clinics.size());
			// Print the new clinic list
			for (HealthClinic clinic : Clinics) {
				System.out.println(clinic.toString());
			}

		} catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader !!!");
				e.printStackTrace();
			}
		}

	}
	
	public static void readLifeCsvFile(String fileName) {

		BufferedReader fileReader = null;
		try {

			// Create a new list of clinics to be filled by CSV file data
			List<LifeExpectancy> lifeExp = new ArrayList<LifeExpectancy>();

			String line = "";

			// Create the file reader
			fileReader = new BufferedReader(new FileReader(fileName));

			// Read the CSV file header to skip it
			fileReader.readLine();

			// Read the file line by line starting from the second line
			while ((line = fileReader.readLine()) != null) {
				// Get all tokens available in line
				String[] tokens = line.split(COMMA_DELIMITER);
				if (tokens.length > 0) {
					// Create a new Clinic object and fill data
					LifeExpectancy lifeE = new LifeExpectancy(
							tokens[COMMUNITYNAME_IDX], Float.parseFloat(tokens[LIFE1999_IDX]),
							Float.parseFloat(tokens[LIFE2000_IDX]), Float.parseFloat(tokens[LIFE2010_IDX]));
					lifeExp.add(lifeE);
				}
			}

			System.out.println("total records = " + lifeExp.size());
			// Print the new clinic list
			for (LifeExpectancy l : lifeExp) {
				System.out.println(l.toString());
			}

		} catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader !!!");
				e.printStackTrace();
			}
		}

	}

}
