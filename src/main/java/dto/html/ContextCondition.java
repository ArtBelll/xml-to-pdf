package dto.html;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.function.Function;

@Value
@AllArgsConstructor
public class ContextCondition {
    private String questionId;
    private String answerId;

    public Function<String, String> isAnswer() {
        return inputAnswerId -> inputAnswerId.equals(String.valueOf(answerId)) ? "V" : "";
    }
}
