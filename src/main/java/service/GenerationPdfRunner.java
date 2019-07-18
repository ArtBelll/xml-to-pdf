package service;

import deserializer.InputDeserializer;
import dto.InputDto;
import dto.html.HtmlContext;
import lombok.AllArgsConstructor;

import java.io.ByteArrayOutputStream;

@AllArgsConstructor
public class GenerationPdfRunner {

    private final String inputXml;
    private final String outputPdf;

    public void run() {
        InputDto input = new InputDeserializer().deserialize(inputXml);
        HtmlContext context = new HtmlContext(input.getApplicant(), input.getCheckConditions().mapAnswerToQuestion());
        ByteArrayOutputStream html = new HtmlCreator().generateHtml(context);
        new PdfCreator().generatePdfFromHtml(html, outputPdf);
    }
}
