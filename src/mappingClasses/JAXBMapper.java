package mappingClasses;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import dtoObjects.ShortCV;
import dtoObjects.UserProfile;

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
	
	public boolean marshallerMethod(UserProfile userProfileObj, File outputXML)
	{
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(userProfileObj.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(userProfileObj, outputXML);
			jaxbMarshaller.marshal(userProfileObj, System.out);
			return true;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}