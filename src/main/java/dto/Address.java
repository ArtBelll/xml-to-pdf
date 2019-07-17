package dto;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

@Getter
public class Address {

    @XmlElement(name = "applicant-addrRegIndex")
    private String index;

    @XmlElement(name = "applicant-addrRegDistrict")
    private String district;

    @XmlElement(name = "applicant-addrRegCity")
    private String city;

    @XmlElement(name = "applicant-addrRegStreet")
    private String street;

    @XmlElement(name = "applicant-addrRegHouse")
    private String house;

    @XmlElement(name = "applicant-addrRegHousing")
    private String housing;

    @XmlElement(name = "applicant-addrRegFlat")
    private String flat;
}
