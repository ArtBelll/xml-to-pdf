package dto;

import dto.html.ContextCondition;

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
            private String questionId;
            @XmlElement(name = "cnd")
            private ConditionCnd cnd;

            private static class ConditionCnd {
                @XmlElement(name = "condition_name")
                private String answerId;
            }
        }
    }

    public Map<String, ContextCondition> mapAnswerToQuestion() {
        return serviceConditions.conditions.stream()
                .collect(Collectors.toMap(
                        condition -> condition.questionId,
                        condition -> new ContextCondition(condition.questionId, condition.cnd.answerId)));
    }
}
