package dto.html;

import dto.Applicant;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class HtmlContext {
    private Applicant applicant;
    private Map<String, ContextCondition> conditions;
}
