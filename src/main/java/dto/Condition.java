package dto;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.function.Function;

@Value
@AllArgsConstructor
public class Condition {
    private int questionId;
    private int answerId;

    public Function<String, String> isAnswer() {
        return inputAnswerId -> inputAnswerId.equals(String.valueOf(answerId)) ? "V" : "";
    }
}
