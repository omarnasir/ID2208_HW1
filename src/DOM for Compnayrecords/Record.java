import java.util.Date;

public class Record {

    private String Company_Name;
    private String Industry;
    private String Designation;
    private String Description;
    private Date startingYear;
    private Date endingtear;

    public String getCompany_Name() {
        return Company_Name;
    }

    public String getIndustry() {
        return Industry;
    }

    public String getDesignation() {
        return Designation;
    }

    public String getDescription() {
        return Description;
    }

    public Date getStartingYear() {
        return startingYear;
    }

    public Date getEndingtear() {
        return endingtear;
    }

    public void setCompany_Name(String company_Name) {
        Company_Name = company_Name;
    }

    public void setIndustry(String industry) {
        Industry = industry;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setStartingYear(Date startingYear) {
        this.startingYear = startingYear;
    }

    public void setEndingtear(Date endingtear) {
        this.endingtear = endingtear;
    }


}
