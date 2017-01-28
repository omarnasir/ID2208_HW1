package dtoObjects;

import java.util.List;

public class ShortCV {
	private String name;
	private Integer phone;
	private Integer age;
	private String gender;
	private String email;
	private String prefLocation;
	private String location;
	private String objective;
	private String tarIndustry;
	private List<String> language;
	private List<String> skills;
	
	
	public String getName() {
		return name;
	}
	public void setName(String Name) {
		this.name = Name;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPrefLocation() {
		return prefLocation;
	}
	public void setPrefLocation(String prefLocation) {
		this.prefLocation = prefLocation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public String getIndustry() {
		return tarIndustry;
	}
	public void setIndustry(String industry) {
		this.tarIndustry = industry;
	}
	public List<String> getLanguage() {
		return language;
	}
	public void setLanguage(List<String> language) {
		this.language = language;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
}
