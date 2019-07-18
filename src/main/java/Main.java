import java.io.ByteArrayOutputStream;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        ByteArrayOutputStream stream = new HtmlCreator().createPdf(new HashMap<>());
        new PdfCreator().generatePdf(stream);
    }
}
