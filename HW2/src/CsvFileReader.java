import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	// private static final int ADDRESS_IDX = 4;
	private static final int COMMUNITYID_IDX = 0;
	private static final int COMMUNITYNAME_IDX = 1;
	private static final int LIFE1999_IDX = 2;

	private static final int LIFE2000_IDX = 5;

	private static final int LIFE2010_IDX = 8;

	/**
	 * Reads the health clinic file and store the data into a list
	 * @param fileName
	 * @param Clinics
	 */
	public static void readClinicCsvFile(String fileName,
			List<HealthClinic> Clinics) {

		BufferedReader fileReader = null;
		try {

			// Create a new list of clinics to be filled by CSV file data
			// List<HealthClinic> Clinics = new ArrayList<HealthClinic>();

			String line = "";

			// Create the file reader
			fileReader = new BufferedReader(new FileReader(fileName));

			// Read the CSV file header to skip it
			fileReader.readLine();

			// Read the file line by line starting from the second line
			while ((line = fileReader.readLine()) != null) {
				// Get all tokens available in line
				String[] data = line.split(COMMA_DELIMITER);
				if (data.length > 0) {
					// Create a new Clinic object and fill data
					HealthClinic clinic = new HealthClinic(
							data[FACILITY_IDX], data[COMMUNITY_IDX],
							data[PHONE_IDX], data[DESCRIPTION_IDX]/*
																	 * , tokens[
																	 * ADDRESS_IDX
																	 * ]
																	 */);
					Clinics.add(clinic);
				}
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

	/**
	 * Reads the Life Expectency file and store the data into a list
	 * Also calculate the number of clinics in each community from clinic list and save it
	 * @param fileName
	 * @param Clinics
	 * @param lifeExp
	 */
	public static void readLifeCsvFile(String fileName,
			List<HealthClinic> Clinics, List<LifeExpectancy> lifeExp) {

		BufferedReader fileReader = null;
		try {

			// Create a new list of data to be filled by CSV file data
			// List<LifeExpectancy> lifeExp = new ArrayList<LifeExpectancy>();

			String line = "";

			// Create the file reader
			fileReader = new BufferedReader(new FileReader(fileName));

			// Read the CSV file header to skip it
			fileReader.readLine();

			// Read the file line by line starting from the second line
			while ((line = fileReader.readLine()) != null) {
				// Get all tokens available in line
				String[] data = line.split(COMMA_DELIMITER);
				if (data.length > 0) {
					// Create a new LifeExpectancy object and fill data
					LifeExpectancy lifeE = new LifeExpectancy(
							Integer.parseInt(data[COMMUNITYID_IDX].trim()),
							data[COMMUNITYNAME_IDX],
							Float.parseFloat(data[LIFE1999_IDX]),
							Float.parseFloat(data[LIFE2000_IDX]),
							Float.parseFloat(data[LIFE2010_IDX]));
					lifeExp.add(lifeE);
				}
			}

			// Adding number of clinics in each area
			for (LifeExpectancy l : lifeExp) {
				int clinicCount = 0;
				for (HealthClinic clinic : Clinics) {
					if (clinic.getCommunity().contains(
							l.getCommunity().toUpperCase())
							&& clinic.getCommunity().contains(
									String.valueOf(l.getCommunityNumber()))) {
						clinicCount++;
					}
				}
				l.setNumberOfClinics(clinicCount);
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
