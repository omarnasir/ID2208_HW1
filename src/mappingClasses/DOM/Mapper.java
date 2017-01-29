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
    private Transcript transcript;

    public Mapper(String xmlFileAddress) {

        this.xmlFileAddress = xmlFileAddress;
        this.transcript = new Transcript();
    }

    public Transcript parseXML() throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setIgnoringComments(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse(new File(xmlFileAddress));

        Element root = doc.getDocumentElement();
        transcript.setName(root.getElementsByTagName("tran:Name").item(0).getFirstChild().getNodeValue());
        transcript.setStudentID(Integer.parseInt(root.getElementsByTagName("tran:StudentID").item(0).getFirstChild().getNodeValue()));
        transcript.setUniversity(root.getElementsByTagName("tran:University").item(0).getFirstChild().getNodeValue());
        transcript.setDegree(root.getElementsByTagName("tran:Degree").item(0).getFirstChild().getNodeValue());

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(root.getElementsByTagName("tran:Startingyear").item(0).getFirstChild().getNodeValue()));

        transcript.setStartingYear(cal.getTime());

        cal.set(Calendar.YEAR, Integer.parseInt(root.getElementsByTagName("tran:Endingyear").item(0).getFirstChild().getNodeValue()));
        transcript.setEndingtear(cal.getTime());

        Course course = new Course();

        int numOfCourses = root.getElementsByTagName("tran:Course").getLength();
        for (int i = 0; i<numOfCourses; i++){
            course = new Course();
            course.setCode(root.getElementsByTagName("tran:Code").item(i).getFirstChild().getNodeValue());
            course.setName(root.getElementsByTagName("tran:Name").item(i+1).getFirstChild().getNodeValue());
            course.setGrade(root.getElementsByTagName("tran:Grade").item(i).getFirstChild().getNodeValue().charAt(0));
            course.setCredits(Double.parseDouble(root.getElementsByTagName("tran:Credits").item(i).getFirstChild().getNodeValue()));
            transcript.addCourse(course);
        }

        return transcript;
    }

    public String toString() {


        SimpleDateFormat df = new SimpleDateFormat("yyyy");

        String result = "Name: " + transcript.getName() + "\n" +
                        "Student ID: " + transcript.getStudentID() + "\n" +
                        "University: " + transcript.getUniversity() + "\n"+
                        "Degree: " + transcript.getDegree() + "\n" +
                        "Starting year: " + df.format(transcript.getStartingYear()) + "\n" +
                        "Ending year: " + df.format(transcript.getEndingtear()) + "\n\n" +
                        "=========== COURSES ===========" + "\n";

            for (int i = 0; i < transcript.getCourseSize(); i++) {
                Course course = transcript.getCourse(i);
                result += "Code: " + course.getCode() + "\n" +
                          "Name: " + course.getName() + "\n" +
                          "Grade: " + course.getGrade() + "\n" +
                          "Credits: " + course.getCredits()+ "\n\n" +
                          "==============================" + "\n\n";
            }

        return result;
    }
}