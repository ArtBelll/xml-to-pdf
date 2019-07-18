import service.GenerationPdfRunner;

public class Main {

    public static void main(String[] args) {
        String inputXml = args[0];
        String outputPdf = args.length >= 2 ? args[1] : "default.pdf";

        new GenerationPdfRunner(inputXml, outputPdf).run();
    }
}
