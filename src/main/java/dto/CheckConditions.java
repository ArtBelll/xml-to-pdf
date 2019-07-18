package dto;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckConditions {

    @XmlElement(name = "serviceConditions")
    private ServiceConditions serviceConditions;

    private static class ServiceConditions {

        @XmlElement(name = "condition")
        private List<Condition> conditions;

        private static class Condition {

            @XmlElement(name = "condition_id")
            private int questionId;
            @XmlElement(name = "cnd")
            private ConditionCnd cnd;

            private static class ConditionCnd {
                @XmlElement(name = "condition_name")
                private int answerId;
            }
        }
    }

    public Map<String, Condition> mapAnswerToQuestion() {
        return serviceConditions.conditions.stream()
                .collect(Collectors.toMap(condition -> String.valueOf(condition.questionId),
                        condition -> new Condition(condition.questionId, condition.cnd.answerId)));
    }
}
