package main;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import dtoObjects.CompanyInfo;
import mappingClasses.SAXMapper;

public class UserProfileGenerator {

	public static void main(String[] args) {
		List<String> companyNames = Arrays.asList("Cloud Computing", "Designers Hub");
		List<CompanyInfo> companyInfoObj;
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File companyXML = new File(classLoader.getResource("./xmlFiles/CompanyInfo.xml").getFile());
		
		SAXMapper saxMapper = new SAXMapper();
		try {
			companyInfoObj = saxMapper.mapperMethod(companyXML, companyNames);
			companyInfoObj.size();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
