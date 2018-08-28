
package com.ichaoge.pet.service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>FIELDINFOCLASS complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="FIELDINFOCLASS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FIELDNAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FIELDVALUE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FIELDTYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FIELDINFOCLASS", propOrder = {
    "fieldname",
    "fieldvalue",
    "fieldtype"
})
public class FIELDINFOCLASS {

    @XmlElement(name = "FIELDNAME", required = true)
    protected String fieldname;
    @XmlElement(name = "FIELDVALUE", required = true)
    protected String fieldvalue;
    @XmlElement(name = "FIELDTYPE", required = true)
    protected String fieldtype;

    /**
     * ��ȡfieldname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIELDNAME() {
        return fieldname;
    }

    /**
     * ����fieldname���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIELDNAME(String value) {
        this.fieldname = value;
    }

    /**
     * ��ȡfieldvalue���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIELDVALUE() {
        return fieldvalue;
    }

    /**
     * ����fieldvalue���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIELDVALUE(String value) {
        this.fieldvalue = value;
    }

    /**
     * ��ȡfieldtype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIELDTYPE() {
        return fieldtype;
    }

    /**
     * ����fieldtype���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIELDTYPE(String value) {
        this.fieldtype = value;
    }

}
