package ChicagoData;

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
		System.out.println("Reading Clinics file");
		FileCSVReader.readClinicCsvFile(fileNameClinic, Clinics);

		List<LifeExpectancy> lifeExp = new ArrayList<LifeExpectancy>();
		System.out.println("Reading Life Expectency file");
		FileCSVReader.readLifeCsvFile(fileNameLife, Clinics, lifeExp);
		String answer;
		do {
			System.out
					.println("\n*******************************************************************************");
			System.out.println("To See Health clinic data enter c \n"
					+ "To See Life Expectency data enter l \n"
					+ "To see the relationship between "
					+ "clinic distribution and life expectency enter y \n"
					+ "Or to exit enter e");
			System.out
					.println("*******************************************************************************\n");

			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			answer = input.nextLine();
			if (answer.equalsIgnoreCase("y")) {
				double cor2010 = getCorrelation(lifeExp, "2010");
				double cor2000 = getCorrelation(lifeExp, "2000");
				double cor1990 = getCorrelation(lifeExp, "1990");
				System.out
						.println("Pearson correlation coefficient for year 2010= "
								+ cor2010);
				System.out
						.println("Pearson correlation coefficient for year 2000= "
								+ cor2000);
				System.out
						.println("Pearson correlation coefficient for year 1990= "
								+ cor1990);
				System.out
						.println("If value is negative it means there is inverse relationship, "
								+ "if the value for X increases, the value of y decreases");

				System.out
						.println("If value is positive it means there is linear relationship, "
								+ "if the value for X increases, the value of y increases");
			} else if (answer.equalsIgnoreCase("l")) {
				// Print the new clinic list
				print(lifeExp);
			} else if (answer.equalsIgnoreCase("c")) {
				// Print the new clinic list
				print(Clinics);
			}
		} while (!answer.equalsIgnoreCase("e"));

	}

	/**
	 * 
	 * @param lifeExpectency
	 *            data
	 * @return correlation coefficient
	 */
	public static double getCorrelation(List<LifeExpectancy> lifeExpectency,
			String year) {
		double meanLifeExp2010 = 0.0, meanLifeExp2000 = 0.0, meanLifeExp1990 = 0.0, meanClinicCount = 0.0;
		for (LifeExpectancy lifeE : lifeExpectency) {
			meanLifeExp2010 += lifeE.getLifeExpectency2010();
			meanLifeExp2000 += lifeE.getLifeExpectency2000();
			meanLifeExp1990 += lifeE.getLifeExpectency1990();
			meanClinicCount += lifeE.getNumberOfClinics();
		}
		int n;
		n = lifeExpectency.size();
		
		//mean or average of lists
		meanLifeExp2010 /= n;
		meanLifeExp1990 /= n;
		meanLifeExp2000 /= n;
		meanClinicCount /= n;

		double sumXY2010 = 0.0, sumX22010 = 0.0, sumY22010 = 0.0;
		double sumXY2000 = 0.0, sumX22000 = 0.0, sumY22000 = 0.0;
		double sumXY1990 = 0.0, sumX21990 = 0.0, sumY21990 = 0.0;
		for (LifeExpectancy lifeE : lifeExpectency) {

			// calculation for 2010
			sumXY2010 += ((lifeE.getLifeExpectency2010() - meanLifeExp2010) * (lifeE
					.getNumberOfClinics() - meanClinicCount));
			sumX22010 += Math.pow(lifeE.getLifeExpectency2010()
					- meanLifeExp2010, 2.0);
			sumY22010 += Math.pow(lifeE.getNumberOfClinics() - meanClinicCount,
					2.0);
			
			System.out.println("lifeE.getLifeExpectency2010()="+lifeE.getLifeExpectency2010()+"meanLifeExp2010="+meanLifeExp2010);
System.out.println("lifeE.getNumberOfClinics()="+lifeE
					.getNumberOfClinics()+"meanClinicCount="+meanClinicCount);
			// calculation for 2000
			sumXY2000 += ((lifeE.getLifeExpectency2000() - meanLifeExp2000) * (lifeE
					.getNumberOfClinics() - meanClinicCount));
			sumX22000 += Math.pow(lifeE.getLifeExpectency2000()
					- meanLifeExp2000, 2.0);
			sumY22000 += Math.pow(lifeE.getNumberOfClinics() - meanClinicCount,
					2.0);

			// calculation for 1990
			sumXY1990 += ((lifeE.getLifeExpectency1990() - meanLifeExp1990) * (lifeE
					.getNumberOfClinics() - meanClinicCount));
			sumX21990 += Math.pow(lifeE.getLifeExpectency1990()
					- meanLifeExp1990, 2.0);
			sumY21990 += Math.pow(lifeE.getNumberOfClinics() - meanClinicCount,
					2.0);
		}

		if (year.equals("2010")) {
			return getCoefficient(sumXY2010, sumX22010, sumY22010);
		} else if (year.equals("2000")) {
			return getCoefficient(sumXY2000, sumX22000, sumY22000);
		} else if (year.equals("1990")) {
			return getCoefficient(sumXY1990, sumX21990, sumY21990);
		}
		return 0;

		// return ((coef2010 + coef2000 + coef1990) / 3);
	}

	/**
	 * 
	 * @param xy
	 * @param x2
	 * @param y2
	 * @return double
	 */
	public static double getCoefficient(double xy, double x2, double y2) {
		return (xy / (Math.sqrt(x2) * Math.sqrt(y2)));
	}

	/**
	 * Print the list
	 * 
	 * @param list
	 */
	public static <E> void print(List<E> list) {
		System.out.println("total records = " + list.size());
		// Print the new clinic list
		for (E data : list) {
			System.out.println(data.toString());
		}
	}

}
