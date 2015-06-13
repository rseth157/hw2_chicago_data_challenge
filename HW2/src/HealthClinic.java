/**
 * 
 * @author Richa
 *
 */
public class HealthClinic {
	String facility;
	String community;
	String phone;
	String description;
	String address;
	
	/**
	 * 
	 * @param facility
	 * @param community
	 * @param phone
	 * @param description
	 * @param address
	 */
	public HealthClinic(String facility,
	String community,	String phone,
	String description/*,
	String address*/){
		
		this.facility = facility;
		this.community =  community;
		this.phone=  phone;
		this.description =  description;
		//this.address=  address;
		
	}

	/**
	 * 
	 * @return facility
	 */
	public String getFacilty() {
		return facility;
	}

	/**
	 * 
	 * @param facility
	 */
	public void setFacilty(String facilty) {
		this.facility = facilty;
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
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {

		return "HealthClinic [facility=" + facility + ", community="
				+ community + ", phone=" + phone + ", description="
				+ description + ", address=" + address + "]";
	}

}
