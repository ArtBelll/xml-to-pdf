package dto;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

@Getter
public class Applicant {

    @XmlElement(name = "applicant-lastName")
    private String lastName;

    @XmlElement(name = "applicant-firstName")
    private String firstName;

    @XmlElement(name = "applicant-middleName")
    private String middleName;

    @XmlElement(name = "applicant-reg_address")
    private Address registrationAddress;

    @XmlElement(name = "applicant-snils")
    private String snils;

    @XmlElement(name = "applicant-phone")
    private String phone;

    public String getFullName() {
        return String.join(" ", lastName, firstName, middleName);
    }
}
