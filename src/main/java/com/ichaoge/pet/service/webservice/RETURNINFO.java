
package com.ichaoge.pet.service.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>RETURNINFO complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="RETURNINFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FLAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TEXTINFO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NEWNODEID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NEWAUTHORS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NEWNODENAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NODEAUTHOR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NODENAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="APPROVER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OTHERINFO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RETURNINFO", propOrder = {
    "flag",
    "textinfo",
    "newnodeid",
    "newauthors",
    "newnodename",
    "nodeauthor",
    "nodename",
    "approver",
    "otherinfo"
})
public class RETURNINFO {

    @XmlElement(name = "FLAG", required = true)
    protected String flag;
    @XmlElement(name = "TEXTINFO", required = true)
    protected String textinfo;
    @XmlElement(name = "NEWNODEID", required = true)
    protected String newnodeid;
    @XmlElement(name = "NEWAUTHORS", required = true)
    protected String newauthors;
    @XmlElement(name = "NEWNODENAME", required = true)
    protected String newnodename;
    @XmlElement(name = "NODEAUTHOR", required = true)
    protected String nodeauthor;
    @XmlElement(name = "NODENAME", required = true)
    protected String nodename;
    @XmlElement(name = "APPROVER", required = true)
    protected String approver;
    @XmlElement(name = "OTHERINFO", required = true)
    protected String otherinfo;

    /**
     * ��ȡflag���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFLAG() {
        return flag;
    }

    /**
     * ����flag���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFLAG(String value) {
        this.flag = value;
    }

    /**
     * ��ȡtextinfo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTEXTINFO() {
        return textinfo;
    }

    /**
     * ����textinfo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTEXTINFO(String value) {
        this.textinfo = value;
    }

    /**
     * ��ȡnewnodeid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNEWNODEID() {
        return newnodeid;
    }

    /**
     * ����newnodeid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNEWNODEID(String value) {
        this.newnodeid = value;
    }

    /**
     * ��ȡnewauthors���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNEWAUTHORS() {
        return newauthors;
    }

    /**
     * ����newauthors���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNEWAUTHORS(String value) {
        this.newauthors = value;
    }

    /**
     * ��ȡnewnodename���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNEWNODENAME() {
        return newnodename;
    }

    /**
     * ����newnodename���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNEWNODENAME(String value) {
        this.newnodename = value;
    }

    /**
     * ��ȡnodeauthor���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNODEAUTHOR() {
        return nodeauthor;
    }

    /**
     * ����nodeauthor���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNODEAUTHOR(String value) {
        this.nodeauthor = value;
    }

    /**
     * ��ȡnodename���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNODENAME() {
        return nodename;
    }

    /**
     * ����nodename���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNODENAME(String value) {
        this.nodename = value;
    }

    /**
     * ��ȡapprover���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPPROVER() {
        return approver;
    }

    /**
     * ����approver���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPPROVER(String value) {
        this.approver = value;
    }

    /**
     * ��ȡotherinfo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTHERINFO() {
        return otherinfo;
    }

    /**
     * ����otherinfo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTHERINFO(String value) {
        this.otherinfo = value;
    }

}
