import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Richa
 *
 */
public class MainClass {

	/**
	 * '
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String fileNameClinic = "Public_Health_Services-_Chicago_Primary_Care_Community_Health_Centers.csv";
		String fileNameLife = "Public_Health_Statistics-_Life_Expectancy_By_Community_Area.csv";

		List<HealthClinic> Clinics = new ArrayList<HealthClinic>();
		System.out.println("\nRead Clinics file:");
		CsvFileReader.readClinicCsvFile(fileNameClinic, Clinics);

		List<LifeExpectancy> lifeExp = new ArrayList<LifeExpectancy>();
		System.out.println("\nRead Life Expectency file:");
		CsvFileReader.readLifeCsvFile(fileNameLife, Clinics, lifeExp);

		System.out
				.println(" To see the relationship between clinic distribution and life expectency enter y");

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String answer = input.nextLine();

		if (answer.equalsIgnoreCase("y")) {
			double cor = GetCorrelation(lifeExp);

			System.out.println(" Correlation is " + cor);
		}

	}

	public static double GetCorrelation(List<LifeExpectancy> lifeExpectency) {
		double meanLifeExp = 0.0, meanClinicCount = 0.0;
		for (LifeExpectancy lifeE : lifeExpectency) {
			meanLifeExp += lifeE.getLifeExpectency2010();
			meanClinicCount += lifeE.getNumberOfClinics();
		}
		System.out.println("meanClinicCount" + meanClinicCount);
		meanLifeExp /= lifeExpectency.size();
		meanClinicCount /= lifeExpectency.size();
		System.out.println("meanClinicCount" + meanClinicCount);

		double sumXY = 0.0, sumX2 = 0.0, sumY2 = 0.0;
		for (LifeExpectancy lifeE : lifeExpectency) {
			sumXY += ((lifeE.getLifeExpectency2010() - meanLifeExp) * (lifeE
					.getNumberOfClinics() - meanClinicCount));
			sumX2 += Math.pow(lifeE.getLifeExpectency2010() - meanLifeExp, 2.0);
			sumY2 += Math
					.pow(lifeE.getNumberOfClinics() - meanClinicCount, 2.0);
		}

		return (sumXY / (Math.sqrt(sumX2) * Math.sqrt(sumY2)));
	}

}
