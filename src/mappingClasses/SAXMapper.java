package mappingClasses;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import dataObjects.CompanyInfo;

public class SAXMapper {

	private List<CompanyInfo> companyInfoListObj = new ArrayList<CompanyInfo>();
	private List<String> companyNames = new ArrayList<String>();

	public List<CompanyInfo> mapperMethod(File xmlFileObj, List<String> companyNames) throws IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parserObj = factory.newSAXParser();
			this.companyNames = companyNames;
			parserObj.parse(xmlFileObj, new CompanyInfoSAXHandler());

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return companyInfoListObj;
	}

	private class CompanyInfoSAXHandler extends DefaultHandler {
		private Stack<String> elementStack = new Stack<String>();
		private Stack<CompanyInfo> objectStack = new Stack<CompanyInfo>();
		private boolean companyExists = false;

		public CompanyInfoSAXHandler() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void startDocument() throws SAXException {
			
		}

		@Override
		public void endDocument() throws SAXException {

		}

		public void startElement(String namespaceURI, String localName, String qName, Attributes attrs){
			this.elementStack.push(qName);
			if (qName.equals("cmp:company")) {
				CompanyInfo companyInfoObj = new CompanyInfo();
				this.objectStack.push(companyInfoObj);
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			this.elementStack.pop();
			if (qName.equals("cmp:company")) {
				CompanyInfo companyInfoObj = this.objectStack.pop();
				if(companyInfoObj.getCompanyName() != null)
				companyInfoListObj.add(companyInfoObj);
			}
			super.endElement(uri, localName, qName);
		}
		
		public void characters(char ch[], int start, int length) {

			String value = new String(ch, start, length).trim();
			if (value.length() == 0)
				return; // ignore white space
			String currentElement = this.elementStack.peek();

			if (currentElement.equals("cmp:companyName")) {
				for(int i = 0; i < companyNames.size(); i++)
				{
				if (value.equals(companyNames.get(i))) {
					CompanyInfo companyInfoObj = this.objectStack.peek();
					companyInfoObj.setCompanyName(value);
					companyExists = true;
					break;
				}
				else
					companyExists = false;
				}
			}

			else if (currentElement.equals("cmp:registrationNumber") && companyExists) {
				CompanyInfo companyInfoObj = this.objectStack.peek();
				companyInfoObj.setRegistrationNumber(value);
			}

			else if (currentElement.equals("cmp:industry") && companyExists) {
				CompanyInfo companyInfoObj = this.objectStack.peek();
				companyInfoObj.setIndustry(value);
			}

			else if (currentElement.equals("cmp:description") && companyExists) {
				CompanyInfo companyInfoObj = this.objectStack.peek();
				companyInfoObj.setDescription(value);
			}

			else if (currentElement.equals("cmp:size") && companyExists) {
				CompanyInfo companyInfoObj = this.objectStack.peek();
				companyInfoObj.setSize(Integer.parseInt(value));
			}

			else if (currentElement.equals("cmp:location") && companyExists) {
				CompanyInfo companyInfoObj = this.objectStack.peek();
				companyInfoObj.setLocation(value);
			}
			else {}
		}
	}
}