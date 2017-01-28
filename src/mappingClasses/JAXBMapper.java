package mappingClasses;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.stream.XMLStreamReader;

import dtoObjects.ShortCV;

@XmlRootElement(name="cv:shortcv")
public class JAXBMapper {
	private ShortCV shortCVObj;
	
	public ShortCV main(XMLStreamReader xsr) {

		 try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ShortCV.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			shortCVObj = (ShortCV) jaxbUnmarshaller.unmarshal(xsr);
			System.out.println(shortCVObj);

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
			return shortCVObj;
		}
}
