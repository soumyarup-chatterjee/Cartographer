
package com.cartographer.xml.message.PACS008;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for Document complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="Document">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="FIToFICstmrCdtTrf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.11}FIToFICustomerCreditTransferV11"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlRootElement(name = "Document")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
    "fiToFICstmrCdtTrf"
})
public class Document {

    @XmlElement(name = "FIToFICstmrCdtTrf", required = true)
    protected FIToFICustomerCreditTransferV11 fiToFICstmrCdtTrf;

    /**
     * Gets the value of the fiToFICstmrCdtTrf property.
     * 
     * @return
     *     possible object is
     *     {@link FIToFICustomerCreditTransferV11 }
     *     
     */
    public FIToFICustomerCreditTransferV11 getFIToFICstmrCdtTrf() {
        return fiToFICstmrCdtTrf;
    }

    /**
     * Sets the value of the fiToFICstmrCdtTrf property.
     * 
     * @param value
     *     allowed object is
     *     {@link FIToFICustomerCreditTransferV11 }
     *     
     */
    public void setFIToFICstmrCdtTrf(FIToFICustomerCreditTransferV11 value) {
        this.fiToFICstmrCdtTrf = value;
    }

}
