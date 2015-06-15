/**
 * 
 * @author Richa
 *
 */
public class LifeExpectancy {
	
	int communityNumber;
	String community;
	float lifeExpectency1990;
	float lifeExpectency1990LowerCI;
	float lifeExpectency1990UpperCI;
	float lifeExpectency2000;
	float lifeExpectency2000LowerCI;
	float lifeExpectency2000UpperCI;
	float lifeExpectency2010;
	float lifeExpectency2010LowerCI;
	float lifeExpectency2010UpperCI;
	float numberOfClinics;
	
	public LifeExpectancy(String community, float lifeExpectency1990, float lifeExpectency2000, float lifeExpectency2010 ){
		this.community =community;
		this.lifeExpectency1990 = lifeExpectency1990;
		this.lifeExpectency2000 = lifeExpectency2000;
		this.lifeExpectency2010 = lifeExpectency2010;
	}
	
	/**
	 * 
	 * @return numberOfClinics
	 */
	public float getNumberOfClinics() {
		return numberOfClinics;
	}

	/**
	 * 
	 * @param numberOfClinics
	 */
	public void setNumberOfClinics(float numberOfClinics) {
		this.numberOfClinics = numberOfClinics;
	}

	/**
	 * 
	 * @return communityNumber
	 */
	public int getCommunityNumber() {
		return communityNumber;
	}
	
	/**
	 * 
	 * @param communityNumber
	 */
	public void setCommunityNumber(int communityNumber) {
		this.communityNumber = communityNumber;
	}
	
	/**
	 * 
	 * @return community
	 */
	public String getCommunity() {
		return community;
	}
	
	/**
	 * 
	 * @param community
	 */
	public void setCommunity(String community) {
		this.community = community;
	}
	
	/**
	 * 
	 * @return lifeExpectency1990
	 */
	public float getLifeExpectency1990() {
		return lifeExpectency1990;
	}
	
	/**
	 * 
	 * @param lifeExpectency1990
	 */
	public void setLifeExpectency1990(float lifeExpectency1990) {
		this.lifeExpectency1990 = lifeExpectency1990;
	}
	
	/**
	 * 
	 * @return lifeExpectency1990LowerCI
	 */
	public float getLifeExpectency1990LowerCI() {
		return lifeExpectency1990LowerCI;
	}
	
	/**
	 * 
	 * @param lifeExpectency1990LowerCI
	 */
	public void setLifeExpectency1990LowerCI(float lifeExpectency1990LowerCI) {
		this.lifeExpectency1990LowerCI = lifeExpectency1990LowerCI;
	}
	
	/**
	 * 
	 * @return getLifeExpectency1990UpperCI
	 */
	public float getLifeExpectency1990UpperCI() {
		return lifeExpectency1990UpperCI;
	}
	
	/**
	 * 
	 * @param lifeExpectency1990UpperCI
	 */
	public void setLifeExpectency1990UpperCI(float lifeExpectency1990UpperCI) {
		this.lifeExpectency1990UpperCI = lifeExpectency1990UpperCI;
	}
	
	/**
	 * 
	 * @return lifeExpectency2000
	 */
	public float getLifeExpectency2000() {
		return lifeExpectency2000;
	}
	
	/**
	 * 
	 * @param lifeExpectency2000
	 */
	public void setLifeExpectency2000(float lifeExpectency2000) {
		this.lifeExpectency2000 = lifeExpectency2000;
	}
	
	/**
	 * 
	 * @return lifeExpectency2000LowerCI
	 */
	public float getLifeExpectency2000LowerCI() {
		return lifeExpectency2000LowerCI;
	}
	
	/**
	 * 
	 * @param lifeExpectency2000LowerCI
	 */
	public void setLifeExpectency2000LowerCI(float lifeExpectency2000LowerCI) {
		this.lifeExpectency2000LowerCI = lifeExpectency2000LowerCI;
	}
	
	/**
	 * 
	 * @return lifeExpectency2000UpperCI
	 */
	public float getLifeExpectency2000UpperCI() {
		return lifeExpectency2000UpperCI;
	}
	
	/**
	 * 
	 * @param lifeExpectency2000UpperCI
	 */
	public void setLifeExpectency2000UpperCI(float lifeExpectency2000UpperCI) {
		this.lifeExpectency2000UpperCI = lifeExpectency2000UpperCI;
	}
	
	/**
	 * 
	 * @return lifeExpectency2010
	 */
	public float getLifeExpectency2010() {
		return lifeExpectency2010;
	}
	
	/**
	 * 
	 * @param lifeExpectency2010
	 */
	public void setLifeExpectency2010(float lifeExpectency2010) {
		this.lifeExpectency2010 = lifeExpectency2010;
	}
	
	/**
	 * 
	 * @return lifeExpectency2010LowerCI
	 */
	public float getLifeExpectency2010LowerCI() {
		return lifeExpectency2010LowerCI;
	}
	
	/**
	 * 
	 * @param lifeExpectency2010LowerCI
	 */
	public void setLifeExpectency2010LowerCI(float lifeExpectency2010LowerCI) {
		this.lifeExpectency2010LowerCI = lifeExpectency2010LowerCI;
	}
	
	/**
	 * 
	 * @return lifeExpectency2010UpperCI
	 */
	public float getLifeExpectency2010UpperCI() {
		return lifeExpectency2010UpperCI;
	}
	
	/**
	 * 
	 * @param lifeExpectency2010UpperCI
	 */
	public void setLifeExpectency2010UpperCI(float lifeExpectency2010UpperCI) {
		this.lifeExpectency2010UpperCI = lifeExpectency2010UpperCI;
	}
	
	@Override
	public String toString() {

		return "Life Expectency [community="
				+ community + ", Number Of Health Clinics=" + communityNumber + ", Life Expectency in 2000="
				+ lifeExpectency2000 + ", Life Expectency in 2010=" + lifeExpectency2010 + "]";
	}
}
