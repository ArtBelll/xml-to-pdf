package service;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import dto.html.HtmlContext;
import lombok.SneakyThrows;

import java.io.*;

public class HtmlCreator {

    private final String TEMPLATE = "template.html";

    @SneakyThrows
    public ByteArrayOutputStream generateHtml(HtmlContext context) {
        InputStream template = getClass().getClassLoader().getResourceAsStream(TEMPLATE);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new OutputStreamWriter(outputStream);
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(new InputStreamReader(template), "temp");
        mustache.execute(writer, context);
        writer.flush();
        return outputStream;
    }
}
