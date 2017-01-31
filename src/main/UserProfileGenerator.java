package main;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;

import dtoObjects.*;
import dtoObjects.userprofile.*;
import mappingClasses.*;

public class UserProfileGenerator {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws XMLStreamException, ParserConfigurationException, SAXException, ParseException {

		List<CompanyInfo> companyInfoObj;
		ShortCV shortCVObj;
		Transcript transcriptObj;
		EmploymentRecord employmentRecordObj;
		
		dtoObjects.userprofile.ObjectFactory factory = new ObjectFactory();
		dtoObjects.userprofile.Userprofile userObj = factory.createUserprofile();
		
		
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
			
			for(int i=0; i<employmentRecordObj.getRecordSize(); i++)
			{
				Userprofile.WorkExperience workExpObj = factory.createUserprofileWorkExperience();
				workExpObj.setCompanyName(employmentRecordObj.getRecord(i).getCompany_Name());
				workExpObj.setDesignation(employmentRecordObj.getRecord(i).getDesignation());
				workExpObj.setStartingYear(DatatypeConverter.parseDate(employmentRecordObj.getRecord(i).getStartingYear()).getTime());
				workExpObj.setEndingYear(DatatypeConverter.parseDate(employmentRecordObj.getRecord(i).getEndingYear()).getTime());
				for(int j=0; j<companyInfoObj.size(); j++)
				{
					if(employmentRecordObj.getRecord(i).getCompany_Name().equals(companyInfoObj.get(j).getCompanyName()))
					{
						if(IndustryType.fromValue(companyInfoObj.get(j).getIndustry())!= null)
						workExpObj.setIndustry(IndustryType.fromValue(companyInfoObj.get(j).getIndustry()));
						workExpObj.setLocation(companyInfoObj.get(j).getLocation());
					}
				}
				userObj.getWorkExperience().add(workExpObj);
			}
			
			userObj.setAge(shortCVObj.getAge());
			userObj.setEmail(shortCVObj.getEmail());
			userObj.setPhone(shortCVObj.getPhone());
			userObj.setGender(shortCVObj.getGender());
			userObj.setTarIndustry(shortCVObj.getIndustry());
			userObj.setLocation(shortCVObj.getLocation());
			userObj.setName(shortCVObj.getName());
			userObj.setObjective(shortCVObj.getObjective());
			userObj.setPrefLocation(shortCVObj.getPrefLocation());
			
			//Convert between List Objects
			for(int i=0; i<shortCVObj.getReferences().getReference().size(); i++)
			{
				userObj.getReferences().getReference().add(shortCVObj.getReferences().getReference().get(i));
			}

			for(int i=0; i<shortCVObj.getLanguages().getLanguage().size(); i++)
			{
				userObj.getLanguages().getLanguage().add(shortCVObj.getLanguages().getLanguage().get(i));
			}
			
			for(int i=0; i<shortCVObj.getSkills().getSkill().size(); i++)
			{
				userObj.getSkills().getSkill().add(shortCVObj.getSkills().getSkill().get(i));
			}

			userObj.setDegree(transcriptObj.getDegree());
			userObj.setGpa(transcriptObj.getTotalGPA());
			userObj.setUniversity(transcriptObj.getUniversity());
			userObj.setEndingyear( transcriptObj.getEndingYear().getYear());
			
			File outputXML = new File("./src/xmlFiles/UserProfile.xml");
			boolean result = jaxbMapper.marshallerMethod(userObj, outputXML);
			
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