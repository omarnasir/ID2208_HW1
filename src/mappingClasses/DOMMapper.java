package mappingClasses;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import dtoObjects.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class DOMMapper {

    private Transcript transcript;
    private EmploymentRecord employmentRecord;

    public Transcript parseTranscriptXML(File xmlFile, String applicantName) throws ParserConfigurationException, IOException, SAXException {

    	this.transcript = new Transcript();
    	
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setIgnoringComments(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);

        Element root = doc.getDocumentElement();
        
        if(applicantName.equals((root.getElementsByTagName("ns:StudentName").item(0).getFirstChild().getNodeValue())))
   		{
	        transcript.setName(root.getElementsByTagName("ns:StudentName").item(0).getFirstChild().getNodeValue());
	        transcript.setStudentID(Integer.parseInt(root.getElementsByTagName("ns:StudentID").item(0).getFirstChild().getNodeValue()));
	        transcript.setUniversity(root.getElementsByTagName("ns:University").item(0).getFirstChild().getNodeValue());
	        transcript.setDegree(root.getElementsByTagName("ns:Degree").item(0).getFirstChild().getNodeValue());
	
	        Calendar cal = Calendar.getInstance();
	        cal.set(Calendar.YEAR, Integer.parseInt(root.getElementsByTagName("ns:Startingyear").item(0).getFirstChild().getNodeValue()));
	
	        transcript.setStartingYear(cal.getTime());
	
	        cal.set(Calendar.YEAR, Integer.parseInt(root.getElementsByTagName("ns:Endingyear").item(0).getFirstChild().getNodeValue()));
	        transcript.setEndingYear(cal.getTime());
	
	        transcript.setTotalGPA(Double.parseDouble(root.getElementsByTagName("ns:TotalGPA").item(0).getFirstChild().getNodeValue()));
	
	        return transcript;
   		}
        return null;
    }

    public EmploymentRecord parseCompanyRecordXML(File xmlFile, String applicantName) throws ParserConfigurationException, IOException, SAXException {

    	this.employmentRecord = new EmploymentRecord();
    	
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setIgnoringComments(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);

        Element root = doc.getDocumentElement();
        if(applicantName.equals((root.getElementsByTagName("emp:Name").item(0).getFirstChild().getNodeValue())))
   		{
        	employmentRecord.setName(root.getElementsByTagName("emp:Name").item(0).getFirstChild().getNodeValue());
	        EmploymentRecordDetail record = new EmploymentRecordDetail();
	
	        int numOfCRecords = root.getElementsByTagName("emp:Record").getLength();
	        for (int i = 0; i<numOfCRecords; i++){
	            record = new EmploymentRecordDetail();
	            record.setCompany_Name(root.getElementsByTagName("emp:Company_Name").item(i).getFirstChild().getNodeValue());
	            record.setDesignation(root.getElementsByTagName("emp:Designation").item(i).getFirstChild().getNodeValue());
	            record.setDescription(root.getElementsByTagName("emp:Description").item(i).getFirstChild().getNodeValue());
	            record.setStartingYear(root.getElementsByTagName("emp:Starting_year").item(i).getFirstChild().getNodeValue());
	            record.setEndingYear(root.getElementsByTagName("emp:Ending_year").item(i).getFirstChild().getNodeValue());
	            employmentRecord.addRecord(record);
	        }
	        return employmentRecord;
   		}
        return null;
    }
}