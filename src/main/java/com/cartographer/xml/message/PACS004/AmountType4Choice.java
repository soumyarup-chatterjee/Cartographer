
package com.cartographer.xml.message.PACS004;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AmountType4Choice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="AmountType4Choice">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <choice>
 *         <element name="InstdAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.12}ActiveOrHistoricCurrencyAndAmount"/>
 *         <element name="EqvtAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.12}EquivalentAmount2"/>
 *       </choice>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountType4Choice", propOrder = {
    "instdAmt",
    "eqvtAmt"
})
public class AmountType4Choice {

    @XmlElement(name = "InstdAmt")
    protected ActiveOrHistoricCurrencyAndAmount instdAmt;
    @XmlElement(name = "EqvtAmt")
    protected EquivalentAmount2 eqvtAmt;

    /**
     * Gets the value of the instdAmt property.
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getInstdAmt() {
        return instdAmt;
    }

    /**
     * Sets the value of the instdAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setInstdAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.instdAmt = value;
    }

    /**
     * Gets the value of the eqvtAmt property.
     * 
     * @return
     *     possible object is
     *     {@link EquivalentAmount2 }
     *     
     */
    public EquivalentAmount2 getEqvtAmt() {
        return eqvtAmt;
    }

    /**
     * Sets the value of the eqvtAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link EquivalentAmount2 }
     *     
     */
    public void setEqvtAmt(EquivalentAmount2 value) {
        this.eqvtAmt = value;
    }

}
