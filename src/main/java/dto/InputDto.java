package dto;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Getter
@XmlRootElement(name = "MfcService")
public class InputDto {
    @XmlElement(name = "applicant")
    private Applicant applicant;
    @XmlElement(name = "check_conditions")
    private CheckConditions checkConditions;
}
