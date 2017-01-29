package dtoObjects;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "shortcv")
public class ShortCV {

	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "phone")
	private Integer phone;
	@XmlElement(name = "age")
	private Integer age;
	@XmlElement(name = "gender")
	private String gender;
	@XmlElement(name = "email")
	private String email;
	@XmlElement(name = "prefLocation")
	private String prefLocation;
	@XmlElement(name = "location")
	private String location;
	@XmlElement(name = "objective")
	private String objective;
	@XmlElement(name = "tarIndustry")
	private String tarIndustry;
	@XmlElement(name = "languages", type = ShortCVLanguages.class)
	private List<ShortCVLanguages> languages;
	@XmlElement(name = "skills", type = ShortCVSkills.class)
	private List<ShortCVSkills> skills;
	@XmlElement(name = "references", type = ShortCVReferences.class)
	private List<ShortCVReferences> references;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<ShortCVLanguages> getLanguages() {
		return languages;
	}

	public void setLanguages(List<ShortCVLanguages> languages) {
		this.languages = languages;
	}

	public List<ShortCVSkills> getSkills() {
		return skills;
	}

	public void setSkills(List<ShortCVSkills> skills) {
		this.skills = skills;
	}

	public List<ShortCVReferences> getReferences() {
		return references;
	}

	public void setReferences(List<ShortCVReferences> references) {
		this.references = references;
	}
}