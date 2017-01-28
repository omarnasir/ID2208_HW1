package main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import dtoObjects.*;
import mappingClasses.*;

public class UserProfileGenerator {

	public static void main(String[] args) throws XMLStreamException {
		List<String> companyNames = Arrays.asList("Cloud Computing", "Designers Hub"); //This will come from Employment Records. Right now its static
		List<CompanyInfo> companyInfoObj;
		ShortCV shortCVObj;
		
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File companyXML = new File(classLoader.getResource("./xmlFiles/CompanyInfo.xml").getFile());
//		File shortCVXML = new File(classLoader.getResource("./xmlFiles/ShortCV.xml").getFile());
		
		XMLInputFactory xif = XMLInputFactory.newFactory();
		InputStream xml = classLoader.getResourceAsStream("./xmlFiles/ShortCV.xml");
		XMLStreamReader xsr = xif.createXMLStreamReader(xml);
		xsr.nextTag();
		while (!xsr.getLocalName().equals("name")) {
			xsr.nextTag();
		}
		
		SAXMapper saxMapper = new SAXMapper();
		JAXBMapper jaxbMapper = new JAXBMapper();
		try {
			companyInfoObj = saxMapper.mapperMethod(companyXML, companyNames);
			companyInfoObj.size();
			
			shortCVObj = jaxbMapper.main(xsr);
			shortCVObj.toString();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}