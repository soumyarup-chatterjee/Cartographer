
package com.cartographer.xml.message.PACS004;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OtherContact1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="OtherContact1">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ChanlTp" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.12}Max4Text"/>
 *         <element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.12}Max128Text" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtherContact1", propOrder = {
    "chanlTp",
    "id"
})
public class OtherContact1 {

    @XmlElement(name = "ChanlTp", required = true)
    protected String chanlTp;
    @XmlElement(name = "Id")
    protected String id;

    /**
     * Gets the value of the chanlTp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChanlTp() {
        return chanlTp;
    }

    /**
     * Sets the value of the chanlTp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChanlTp(String value) {
        this.chanlTp = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
