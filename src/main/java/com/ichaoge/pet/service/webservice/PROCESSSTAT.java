
package com.ichaoge.pet.service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PROCESSSTAT complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PROCESSSTAT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FLAG" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="STATINFO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DOCUNID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PROCESSSTAT", propOrder = {
    "flag",
    "statinfo",
    "docunid"
})
public class PROCESSSTAT {

    @XmlElement(name = "FLAG")
    protected boolean flag;
    @XmlElement(name = "STATINFO", required = true)
    protected String statinfo;
    @XmlElement(name = "DOCUNID", required = true)
    protected String docunid;

    /**
     * ��ȡflag���Ե�ֵ��
     * 
     */
    public boolean isFLAG() {
        return flag;
    }

    /**
     * ����flag���Ե�ֵ��
     * 
     */
    public void setFLAG(boolean value) {
        this.flag = value;
    }

    /**
     * ��ȡstatinfo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTATINFO() {
        return statinfo;
    }

    /**
     * ����statinfo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTATINFO(String value) {
        this.statinfo = value;
    }

    /**
     * ��ȡdocunid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDOCUNID() {
        return docunid;
    }

    /**
     * ����docunid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDOCUNID(String value) {
        this.docunid = value;
    }

}
