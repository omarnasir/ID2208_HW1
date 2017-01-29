public class Record {

    private String Company_Name;
    private String Industry;
    private String Designation;
    private String Description;
    private String StartingYear;
    private String Endingtear;


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

    public String getStartingYear() {
        return StartingYear;
    }

    public String getEndingYear() {
        return Endingtear;
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

    public void setStartingYear(String startingYear) {
        this.StartingYear = startingYear;
    }

    public void setEndingYear(String endingtear) {
        this.Endingtear = endingtear;
    }


}
