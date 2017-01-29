package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;

import dtoObjects.*;
import mappingClasses.*;

public class UserProfileGenerator {

	public static void main(String[] args) throws XMLStreamException, ParserConfigurationException, SAXException {
		//This will come from Employment Records. Right now its static
		List<CompanyInfo> companyInfoObj;
		ShortCV shortCVObj;
		Transcript transcriptObj;
		EmploymentRecord employmentRecordObj;
		UserProfile userProfileObj = new UserProfile();
		
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File companyXML = new File(classLoader.getResource("./xmlFiles/CompanyInfo.xml").getFile());
		File shortCVXML = new File(classLoader.getResource("./xmlFiles/ShortCV.xml").getFile());
		File employmentRecordsXML = new File(classLoader.getResource("./xmlFiles/EmploymentRecords.xml").getFile());	
		File transcriptXML = new File(classLoader.getResource("./xmlFiles/Transcript.xml").getFile());
		File transcriptXSLT = new File(classLoader.getResource("./xslFiles/transform.xsl").getFile());
		String newTranscriptXMLpath = "./src/xmlFiles/newTranscript.xml";
		
		StreamSource transcriptXSL = new StreamSource(transcriptXSLT);		
		
		SAXMapper saxMapper = new SAXMapper();
		JAXBMapper jaxbMapper = new JAXBMapper();
		DOMMapper domMapper = new DOMMapper();
		
		try {
			shortCVObj = jaxbMapper.mapperMethod(shortCVXML);
			
			employmentRecordObj = domMapper.parseCompanyRecordXML(employmentRecordsXML, shortCVObj.getName());
			
			List<String> companyNames = employmentRecordObj.getCompanyNames(); 
			companyInfoObj = saxMapper.mapperMethod(companyXML, companyNames);			
			
			XSLTMapper.convertXMLToHTML(new StreamSource(transcriptXML), transcriptXSL, newTranscriptXMLpath);
			transcriptObj = domMapper.parseTranscriptXML(new File(newTranscriptXMLpath), shortCVObj.getName());
				
			List<UserProfileWorkExperienceDetail> workExperienceObj = new ArrayList<UserProfileWorkExperienceDetail>();
			for(int i=0; i<employmentRecordObj.getRecordSize(); i++)
			{
				UserProfileWorkExperienceDetail obj = new UserProfileWorkExperienceDetail();
				obj.setCompany_Name(employmentRecordObj.getRecord(i).getCompany_Name());
				obj.setDesignation(employmentRecordObj.getRecord(i).getDesignation());
				obj.setStartingYear(employmentRecordObj.getRecord(i).getStartingYear());
				obj.setEndingtear(employmentRecordObj.getRecord(i).getEndingYear());
				for(int j=0; j<companyInfoObj.size(); j++)
				{
					if(employmentRecordObj.getRecord(i).getCompany_Name().equals(companyInfoObj.get(j).getCompanyName()))
					obj.setIndustry(companyInfoObj.get(j).getIndustry());
					obj.setLocation(companyInfoObj.get(j).getLocation());
				}
				workExperienceObj.add(obj);
			}
			
			userProfileObj.setRecordObj(workExperienceObj);
			
			userProfileObj.setShortCVObj(shortCVObj);
			userProfileObj.setDegree(transcriptObj.getDegree());
			userProfileObj.setGpa(transcriptObj.getTotal_credits());
			userProfileObj.setUniversity(transcriptObj.getUniversity());
			userProfileObj.setEndingyear(transcriptObj.getEndingYear());
			
			File outputXML = new File("./src/xmlFiles/UserProfile.xml");
			boolean result = jaxbMapper.marshallerMethod(userProfileObj, outputXML);
			
			if(result)
				System.out.println("Success!");
			else
				System.out.println("Failure.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}