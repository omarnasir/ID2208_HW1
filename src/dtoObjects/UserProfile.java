package dtoObjects;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserProfile {
	private ShortCV shortCVObj;
	private List<UserProfileWorkExperienceDetail> recordObj;
	
    private String university;
    private String degree;
    private Date endingyear;
    private Double gpa;
	
	public ShortCV getShortCVObj() {
		return shortCVObj;
	}

	public void setShortCVObj(ShortCV shortCVObj) {
		this.shortCVObj = shortCVObj;
	}

	public List<UserProfileWorkExperienceDetail> getRecordObj() {
		return recordObj;
	}

	public void setRecordObj(List<UserProfileWorkExperienceDetail> recordObj) {
		this.recordObj = recordObj;
	}
    
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public Date getEndingyear() {
		return endingyear;
	}
	public void setEndingyear(Date endingyear) {
		this.endingyear = endingyear;
	}
	public Double getGpa() {
		return gpa;
	}
	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}
    
	
}
