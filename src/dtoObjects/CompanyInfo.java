package dtoObjects;

public class CompanyInfo {
	private String CompanyName;
	private Integer RegistrationNumber;
	private String Industry;
	private String Description;
	private Integer Size;
	private String location;
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public Integer getRegistrationNumber() {
		return RegistrationNumber;
	}
	public void setRegistrationNumber(Integer registrationNumber) {
		RegistrationNumber = registrationNumber;
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
