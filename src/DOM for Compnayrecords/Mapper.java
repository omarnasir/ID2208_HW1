import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Mapper {

    private String xmlFileAddress;
    private Companyrecord companyrecord;

    public Mapper(String xmlFileAddress) {

        this.xmlFileAddress = xmlFileAddress;
        this.companyrecord = new Companyrecord();
    }

    public Companyrecord parseXML() throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setIgnoringComments(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse(new File(xmlFileAddress));

        Element root = doc.getDocumentElement();
        companyrecord.setName(root.getElementsByTagName("emp:Name").item(0).getFirstChild().getNodeValue());


        Record record = new Record();

        int numOfCRecords = root.getElementsByTagName("emp:Record").getLength();
        for (int i = 0; i<numOfCRecords; i++){
            record = new Record();
            record.setCompany_Name(root.getElementsByTagName("emp:Company_Name").item(i).getFirstChild().getNodeValue());
            record.setIndustry(root.getElementsByTagName("emp:Industry").item(i).getFirstChild().getNodeValue());
            record.setDesignation(root.getElementsByTagName("emp:Designation").item(i).getFirstChild().getNodeValue());
            record.setDescription(root.getElementsByTagName("emp:Description").item(i).getFirstChild().getNodeValue());
            companyrecord.addRecord(record);
        }

        return companyrecord;
    }

    public String toString() {

        String result = "Name: " + companyrecord.getName() + "\n" +

                        "=========== RecordS ===========" + "\n";
        for (int i = 0; i < companyrecord.getRecordSize(); i++) {
            Record record = companyrecord.getRecord(i);
                result += "CompanyName: " + record.getCompany_Name() + "\n" +
                          "Industry: " + record.getIndustry() + "\n" +
                          "Designation: " + record.getDesignation() + "\n" +
                          "Description: " + record.getDescription()+ "\n\n" +
                          "==============================" + "\n\n";
            }
        return result;
    }
}