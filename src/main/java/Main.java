import deserializer.InputDeserializer;
import dto.InputDto;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        InputDto input = new InputDeserializer().deserialize("input.xml");

        Map<String, Object> scopes = new HashMap<>();
        scopes.put("applicant", input.getApplicant());
        scopes.put("conditions", input.getCheckConditions().mapAnswerToQuestion());

        ByteArrayOutputStream stream = new HtmlCreator().generateHtml(scopes);
        new PdfCreator().generatePdf(stream);
    }
}
