package main;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import dtoObjects.*;
import mappingClasses.*;

public class UserProfileGenerator {

	public static void main(String[] args) throws XMLStreamException {
		List<String> companyNames = Arrays.asList("Cloud Computing", "Designers Hub"); //This will come from Employment Records. Right now its static
		List<CompanyInfo> companyInfoObj;
		ShortCV shortCVObj;
		
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File companyXML = new File(classLoader.getResource("./xmlFiles/CompanyInfo.xml").getFile());
		File shortCVXML = new File(classLoader.getResource("./xmlFiles/ShortCV.xml").getFile());
		//Add File reference to Company Record.xml
		//Add File reference to Transcript.xml		
		
		SAXMapper saxMapper = new SAXMapper();
		JAXBMapper jaxbMapper = new JAXBMapper();
		//Add Mapper for CompanyRecord
		//Add Mapper for Transcript
		try {
			companyInfoObj = saxMapper.mapperMethod(companyXML, companyNames);			
			shortCVObj = jaxbMapper.mapperMethod(shortCVXML);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}