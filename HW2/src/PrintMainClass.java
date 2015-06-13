/**
 * 
 * @author Richa
 *
 */
public class PrintMainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String fileName =  "Public_Health_Services-_Chicago_Primary_Care_Community_Health_Centers.csv";


		System.out.println("\nRead CSV file:");
		CsvFileReader.readCsvFile(fileName);

	}

}
