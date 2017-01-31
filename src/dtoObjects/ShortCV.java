package dtoObjects;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "shortcv")
public class ShortCV {

	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "phone")
	private BigInteger phone;
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
	@XmlElement(required = true)
	protected ShortCV.Languages languages;
	@XmlElement(required = true)
	protected ShortCV.Skills skills;
	@XmlElement(required = true)
	protected ShortCV.References references;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getPhone() {
		return phone;
	}

	public void setPhone(BigInteger phone) {
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

	public ShortCV.Languages getLanguages() {
		return languages;
	}

	/**
	 * Sets the value of the languages property.
	 * 
	 * @param value
	 *            allowed object is {@link Shortcv.Languages }
	 * 
	 */
	public void setLanguages(ShortCV.Languages value) {
		this.languages = value;
	}

	/**
	 * Gets the value of the skills property.
	 * 
	 * @return possible object is {@link Shortcv.Skills }
	 * 
	 */
	public ShortCV.Skills getSkills() {
		return skills;
	}

	/**
	 * Sets the value of the skills property.
	 * 
	 * @param value
	 *            allowed object is {@link Shortcv.Skills }
	 * 
	 */
	public void setSkills(ShortCV.Skills value) {
		this.skills = value;
	}

	/**
	 * Gets the value of the references property.
	 * 
	 * @return possible object is {@link Shortcv.References }
	 * 
	 */
	public ShortCV.References getReferences() {
		return references;
	}

	/**
	 * Sets the value of the references property.
	 * 
	 * @param value
	 *            allowed object is {@link Shortcv.References }
	 * 
	 */
	public void setReferences(ShortCV.References value) {
		this.references = value;
	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="5" minOccurs="0"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "language" })
	public static class Languages {

		protected List<String> language;

		/**
		 * Gets the value of the language property.
		 * 
		 * <p>
		 * This accessor method returns a reference to the live list, not a
		 * snapshot. Therefore any modification you make to the returned list
		 * will be present inside the JAXB object. This is why there is not a
		 * <CODE>set</CODE> method for the language property.
		 * 
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getLanguage().add(newItem);
		 * </pre>
		 * 
		 * 
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link String }
		 * 
		 * 
		 */
		public List<String> getLanguage() {
			if (language == null) {
				language = new ArrayList<String>();
			}
			return this.language;
		}

	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="5" minOccurs="0"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "reference" })
	public static class References {

		protected List<String> reference;

		/**
		 * Gets the value of the reference property.
		 * 
		 * <p>
		 * This accessor method returns a reference to the live list, not a
		 * snapshot. Therefore any modification you make to the returned list
		 * will be present inside the JAXB object. This is why there is not a
		 * <CODE>set</CODE> method for the reference property.
		 * 
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getReference().add(newItem);
		 * </pre>
		 * 
		 * 
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link String }
		 * 
		 * 
		 */
		public List<String> getReference() {
			if (reference == null) {
				reference = new ArrayList<String>();
			}
			return this.reference;
		}

	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="skill" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="5" minOccurs="0"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "skill" })
	public static class Skills {

		protected List<String> skill;

		/**
		 * Gets the value of the skill property.
		 * 
		 * <p>
		 * This accessor method returns a reference to the live list, not a
		 * snapshot. Therefore any modification you make to the returned list
		 * will be present inside the JAXB object. This is why there is not a
		 * <CODE>set</CODE> method for the skill property.
		 * 
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getSkill().add(newItem);
		 * </pre>
		 * 
		 * 
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link String }
		 * 
		 * 
		 */
		public List<String> getSkill() {
			if (skill == null) {
				skill = new ArrayList<String>();
			}
			return this.skill;
		}

	}

}
