
package com.cartographer.xml.message.PACS004;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentMethod4Code.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>{@code
 * <simpleType name="PaymentMethod4Code">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="CHK"/>
 *     <enumeration value="TRF"/>
 *     <enumeration value="DD"/>
 *     <enumeration value="TRA"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "PaymentMethod4Code")
@XmlEnum
public enum PaymentMethod4Code {

    CHK,
    TRF,
    DD,
    TRA;

    public String value() {
        return name();
    }

    public static PaymentMethod4Code fromValue(String v) {
        return valueOf(v);
    }

}
