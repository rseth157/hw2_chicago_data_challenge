/**
 * 
 * @author Richa
 *
 */
public class PrintMainClass {

	/**'
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String fileNameClinic =  "Public_Health_Services-_Chicago_Primary_Care_Community_Health_Centers.csv";
		String fileNameLife =  "Public_Health_Statistics-_Life_Expectancy_By_Community_Area.csv";

		System.out.println("\nRead Clinics file:");
		CsvFileReader.readClinicCsvFile(fileNameClinic);
		
		System.out.println("\nRead Life Expectency file:");
		CsvFileReader.readLifeCsvFile(fileNameLife);

	}

}
