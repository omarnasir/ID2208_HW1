package dtoObjects;

public class CompanyInfo {
	private String CompanyID;
	private String CompanyName;
	private String RegistrationNumber;
	private String Industry;
	private String Description;
	private Integer Size;
	private String location;
	
	public String getCompanyID() {
		return CompanyID;
	}
	public void setCompanyID(String companyID) {
		CompanyID = companyID;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getRegistrationNumber() {
		return RegistrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.RegistrationNumber = registrationNumber;
	}
	public String getIndustry() {
		return Industry;
	}
	public void setIndustry(String industry) {
		Industry = industry;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Integer getSize() {
		return Size;
	}
	public void setSize(Integer size) {
		Size = size;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
