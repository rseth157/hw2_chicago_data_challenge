package ChicagoData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

		// CSV files from Chicago data portal
		String fileNameClinic = "Public_Health_Services-_Chicago_Primary_Care_Community_Health_Centers.csv";
		String fileNameLife = "Public_Health_Statistics-_Life_Expectancy_By_Community_Area.csv";

		// Reading the health clinic file and storing it in list
		List<HealthClinic> Clinics = new ArrayList<HealthClinic>();
		System.out.println("Reading Clinics file");
		FileCSVReader.readClinicCsvFile(fileNameClinic, Clinics);

		// Reading the Life expectancy file and storing it in list, also
		// calculate number of clinics in area
		List<LifeExpectancy> lifeExp = new ArrayList<LifeExpectancy>();
		System.out.println("Reading Life Expectency file");
		FileCSVReader.readLifeCsvFile(fileNameLife, Clinics, lifeExp);

		// Console output
		String answer;
		do {
			System.out
					.println("\n*******************************************************************************");
			System.out
					.println("To See Health clinic data enter c \n"
							+ "To See Life Expectency data enter l \n"
							+ "To see the relationship between "
							+ "clinic distribution and life expectency enter r \n"
							+ "To check number of clinic distribution across the community enter d \n"
							+ "Or to exit enter e");
			System.out
					.println("*******************************************************************************\n");

			// Reading Input
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			answer = input.nextLine();

			System.out.println("Result is");
			// For getting relationship between life expectancy and clinic count
			if (answer.equalsIgnoreCase("r")) {
				Map<String, Double> result = getCorrelation(lifeExp);
				double cor2010 = result.get("2010");
				double cor2000 = result.get("2000");
				double cor1990 = result.get("1990");
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
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
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			} else if (answer.equalsIgnoreCase("l")) { // for health file data
				// Print the new clinic list
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				print(lifeExp);
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			} else if (answer.equalsIgnoreCase("c")) { // for health clinic file
														// data
				// Print the new clinic list
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				print(Clinics);
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			} else if (answer.equalsIgnoreCase("d")) { // for finding if the
														// distribution is even
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("Variance mean ratio is = "
						+ getVMR(lifeExp));
				System.out
						.println("Relationship between Distribution and	VMR	\n"
								+ "constant random variable\tVMR = 0\tnot dispersed\n"
								+ "binomial distribution \t0 < VMR < 1\tunder-dispersed\n"
								+ "Poisson distribution	VMR = 1\n"
								+ "negative binomial distribution \tVMR > 1\tover-dispersed");
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			}
		} while (!answer.equalsIgnoreCase("e")); // exit the running program

	}

	/**
	 * 
	 * @param lifeExpectency
	 *            data
	 * @return correlation coefficient
	 */
	public static Map<String, Double> getCorrelation(
			List<LifeExpectancy> lifeExpectency) {
		double meanLifeExp2010 = 0.0, meanLifeExp2000 = 0.0, meanLifeExp1990 = 0.0, meanClinicCount = 0.0;
		for (LifeExpectancy lifeE : lifeExpectency) {
			meanLifeExp2010 += lifeE.getLifeExpectency2010();
			meanLifeExp2000 += lifeE.getLifeExpectency2000();
			meanLifeExp1990 += lifeE.getLifeExpectency1990();
			meanClinicCount += lifeE.getNumberOfClinics();
		}
		int n;
		n = lifeExpectency.size();

		// mean or average of lists
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

		Map<String, Double> result = new HashMap<String, Double>();
		result.put("2010", getCoefficient(sumXY2010, sumX22010, sumY22010));
		result.put("2000", getCoefficient(sumXY2000, sumX22000, sumY22000));
		result.put("1990", getCoefficient(sumXY1990, sumX21990, sumY21990));
		return result;

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

	/**
	 * Index of dispersion Distribution
	 */
	public static double getVMR(List<LifeExpectancy> lifeExpectency) {
		double vmr = 0.0, mean = 0.0, standardD = 0.0;

		// calculating mean and standard deviation
		for (LifeExpectancy life : lifeExpectency) {
			mean += life.getNumberOfClinics();
		}

		mean = mean / lifeExpectency.size();

		// calculating variance
		for (LifeExpectancy life : lifeExpectency) {
			float x = life.getNumberOfClinics();
			standardD += (x - mean) * (x - mean);
		}
		standardD = standardD / (lifeExpectency.size() - 1);

		// variance mean ratio
		vmr = standardD / mean;
		return vmr;
	}
}
