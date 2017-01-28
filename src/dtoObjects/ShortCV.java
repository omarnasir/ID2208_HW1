package dtoObjects;

import java.util.List;

public class ShortCV {
	private String Name;
	private Integer Phone;
	private Integer Age;
	private String Gender;
	private String Email;
	private String PrefLocation;
	private String Location;
	private String Objective;
	private String Industry;
	private List<String> Language;
	private List<String> Skills;
	
	
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public Integer getPhone() {
		return Phone;
	}
	public void setPhone(Integer phone) {
		Phone = phone;
	}
	public Integer getAge() {
		return Age;
	}
	public void setAge(Integer age) {
		Age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPrefLocation() {
		return PrefLocation;
	}
	public void setPrefLocation(String prefLocation) {
		PrefLocation = prefLocation;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getObjective() {
		return Objective;
	}
	public void setObjective(String objective) {
		Objective = objective;
	}
	public String getIndustry() {
		return Industry;
	}
	public void setIndustry(String industry) {
		Industry = industry;
	}
	public List<String> getLanguage() {
		return Language;
	}
	public void setLanguage(List<String> language) {
		Language = language;
	}
	public List<String> getSkills() {
		return Skills;
	}
	public void setSkills(List<String> skills) {
		Skills = skills;
	}
	
}
