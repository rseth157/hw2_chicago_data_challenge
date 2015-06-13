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

	// Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";

	// HealthClinic attributes index
	private static final int FACILITY_IDX = 0;
	private static final int COMMUNITY_IDX = 1;
	private static final int DESCRIPTION_IDX = 3;
	private static final int PHONE_IDX = 2;
	private static final int ADDRESS_IDX = 4;

	public static void readCsvFile(String fileName) {

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
							tokens[PHONE_IDX], tokens[DESCRIPTION_IDX],
							tokens[ADDRESS_IDX]);
					Clinics.add(clinic);
				}
			}

			// Print the new student list
			for (HealthClinic clinic : Clinics) {
				System.out.println(Clinics.toString());
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
