import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class DOM {

    public static void main(String argv[]) throws IOException, SAXException, ParserConfigurationException {

        Mapper mapper = new Mapper("Companyrecord.xml");
        mapper.parseXML();
        System.out.println(mapper);

    }
}