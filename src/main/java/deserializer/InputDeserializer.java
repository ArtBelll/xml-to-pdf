package deserializer;

import dto.InputDto;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;

public class InputDeserializer {

    public InputDto deserialize(String filePath) {
        try {
            FileInputStream file = new FileInputStream(filePath);
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            Document document = builderFactory.newDocumentBuilder().parse(file);

            JAXBContext jaxbContext = JAXBContext.newInstance(InputDto.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (InputDto) unmarshaller.unmarshal(document.getElementsByTagName("MfcService").item(0));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
