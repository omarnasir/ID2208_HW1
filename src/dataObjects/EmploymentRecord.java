package dataObjects;

import java.util.ArrayList;
import java.util.List;

public class EmploymentRecord{

    private String name;

    private ArrayList<EmploymentRecordDetail> records;

    public EmploymentRecord() {
        this.records = new ArrayList<EmploymentRecordDetail>();
    }

    public ArrayList<EmploymentRecordDetail> getAllRecords()
    {
    	return this.records;
    }
    
    public EmploymentRecordDetail getRecord(int num) {
        return records.get(num);
    }

    public int getRecordSize() { return records.size();}

    public List<String> getCompanyNames ()
    {
    	List<String> companyNames = new ArrayList<String>();
    	for(int i=0; i < getRecordSize(); i++)
    	{
    		companyNames.add(getRecord(i).getCompany_Name());
    	}
    	return companyNames;
    }

    public void addRecord(EmploymentRecordDetail record) {
        records.add(record);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
