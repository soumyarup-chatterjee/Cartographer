
package com.cartographer.xml.message.PACS004;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountIdentification4Choice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="AccountIdentification4Choice">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <choice>
 *         <element name="IBAN" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.12}IBAN2007Identifier"/>
 *         <element name="Othr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.12}GenericAccountIdentification1"/>
 *       </choice>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountIdentification4Choice", propOrder = {
    "iban",
    "othr"
})
public class AccountIdentification4Choice {

    @XmlElement(name = "IBAN")
    protected String iban;
    @XmlElement(name = "Othr")
    protected GenericAccountIdentification1 othr;

    /**
     * Gets the value of the iban property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBAN() {
        return iban;
    }

    /**
     * Sets the value of the iban property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBAN(String value) {
        this.iban = value;
    }

    /**
     * Gets the value of the othr property.
     * 
     * @return
     *     possible object is
     *     {@link GenericAccountIdentification1 }
     *     
     */
    public GenericAccountIdentification1 getOthr() {
        return othr;
    }

    /**
     * Sets the value of the othr property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericAccountIdentification1 }
     *     
     */
    public void setOthr(GenericAccountIdentification1 value) {
        this.othr = value;
    }

}
