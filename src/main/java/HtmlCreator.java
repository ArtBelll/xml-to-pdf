import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import lombok.SneakyThrows;

import java.io.*;
import java.util.Map;

public class HtmlCreator {

    @SneakyThrows
    public ByteArrayOutputStream generateHtml(Map<String, Object> scopes) {
        InputStream template = this.getClass().getResourceAsStream("template.html");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new OutputStreamWriter(outputStream);
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(new InputStreamReader(template), "temp.html");
        mustache.execute(writer, scopes);
        writer.flush();
        return outputStream;
    }
}
