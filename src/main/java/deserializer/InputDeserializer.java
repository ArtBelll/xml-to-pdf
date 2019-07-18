package deserializer;

import dto.InputDto;
import lombok.SneakyThrows;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;

public class InputDeserializer {

    private static final String ROOT_TAG = "MfcService";

    @SneakyThrows
    public InputDto deserialize(String filePath) {
        FileInputStream file = new FileInputStream(filePath);
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        Document document = builderFactory.newDocumentBuilder().parse(file);

        JAXBContext jaxbContext = JAXBContext.newInstance(InputDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (InputDto) unmarshaller.unmarshal(document.getElementsByTagName(ROOT_TAG).item(0));
    }
}
