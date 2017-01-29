package mappingClasses;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import dtoObjects.ShortCV;

public class JAXBMapper {
	private ShortCV shortCVObj;

	public ShortCV mapperMethod(File shortCVXML) {

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ShortCV.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			shortCVObj = (ShortCV) jaxbUnmarshaller.unmarshal(shortCVXML);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return shortCVObj;
	}
}