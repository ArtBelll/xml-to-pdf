package service;

import com.openhtmltopdf.extend.FSSupplier;
import com.openhtmltopdf.outputdevice.helper.BaseRendererBuilder;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import lombok.SneakyThrows;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PdfCreator {

    private static final String REGULAR_FONT_PATH = "OpenSans-Regular.ttf";

    @SneakyThrows
    public void generatePdfFromHtml(ByteArrayOutputStream html, String pdfPath) {
        try (OutputStream os = new FileOutputStream(pdfPath)) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.useFont(getFontSupplier(REGULAR_FONT_PATH), "Open Sans", 400,
                    BaseRendererBuilder.FontStyle.NORMAL, true);
            builder.withHtmlContent(new String(html.toByteArray(), StandardCharsets.UTF_8), pdfPath);
            builder.toStream(os);
            builder.run();
        }
    }

    private FSSupplier<InputStream> getFontSupplier(String fontPath) {
        return () -> this.getClass().getClassLoader().getResourceAsStream(fontPath);
    }

}
