
package com.cartographer.xml.message.PACS004;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentType6Code.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>{@code
 * <simpleType name="DocumentType6Code">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="MSIN"/>
 *     <enumeration value="CNFA"/>
 *     <enumeration value="DNFA"/>
 *     <enumeration value="CINV"/>
 *     <enumeration value="CREN"/>
 *     <enumeration value="DEBN"/>
 *     <enumeration value="HIRI"/>
 *     <enumeration value="SBIN"/>
 *     <enumeration value="CMCN"/>
 *     <enumeration value="SOAC"/>
 *     <enumeration value="DISP"/>
 *     <enumeration value="BOLD"/>
 *     <enumeration value="VCHR"/>
 *     <enumeration value="AROI"/>
 *     <enumeration value="TSUT"/>
 *     <enumeration value="PUOR"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "DocumentType6Code")
@XmlEnum
public enum DocumentType6Code {

    MSIN,
    CNFA,
    DNFA,
    CINV,
    CREN,
    DEBN,
    HIRI,
    SBIN,
    CMCN,
    SOAC,
    DISP,
    BOLD,
    VCHR,
    AROI,
    TSUT,
    PUOR;

    public String value() {
        return name();
    }

    public static DocumentType6Code fromValue(String v) {
        return valueOf(v);
    }

}
