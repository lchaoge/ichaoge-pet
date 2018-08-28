
package com.ichaoge.pet.service.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DIGIFLOWPARA complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DIGIFLOWPARA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="USERNAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PASSWORD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SERVER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DBPATH" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FORMNAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CREATEREN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CREATERCN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="APPROVEREN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FILEDLIST" type="{urn:DefaultNamespace}FIELDINFOCLASS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TONODEID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DOCUNID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MSGSUBJECT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FLOWKEY" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DIGIFLOWPARA", propOrder = {
    "username",
    "password",
    "server",
    "dbpath",
    "formname",
    "createren",
    "creatercn",
    "approveren",
    "filedlist",
    "tonodeid",
    "docunid",
    "msgsubject",
    "flowkey"
})
public class DIGIFLOWPARA {

    @XmlElement(name = "USERNAME", required = true)
    protected String username;
    @XmlElement(name = "PASSWORD", required = true)
    protected String password;
    @XmlElement(name = "SERVER", required = true)
    protected String server;
    @XmlElement(name = "DBPATH", required = true)
    protected String dbpath;
    @XmlElement(name = "FORMNAME", required = true)
    protected String formname;
    @XmlElement(name = "CREATEREN", required = true)
    protected String createren;
    @XmlElement(name = "CREATERCN", required = true)
    protected String creatercn;
    @XmlElement(name = "APPROVEREN", required = true)
    protected String approveren;
    @XmlElement(name = "FILEDLIST", nillable = true)
    protected List<FIELDINFOCLASS> filedlist;
    @XmlElement(name = "TONODEID", required = true)
    protected String tonodeid;
    @XmlElement(name = "DOCUNID", required = true)
    protected String docunid;
    @XmlElement(name = "MSGSUBJECT", required = true)
    protected String msgsubject;
    @XmlElement(name = "FLOWKEY", required = true)
    protected String flowkey;

    /**
     * ��ȡusername���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERNAME() {
        return username;
    }

    /**
     * ����username���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERNAME(String value) {
        this.username = value;
    }

    /**
     * ��ȡpassword���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPASSWORD() {
        return password;
    }

    /**
     * ����password���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPASSWORD(String value) {
        this.password = value;
    }

    /**
     * ��ȡserver���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVER() {
        return server;
    }

    /**
     * ����server���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVER(String value) {
        this.server = value;
    }

    /**
     * ��ȡdbpath���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDBPATH() {
        return dbpath;
    }

    /**
     * ����dbpath���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDBPATH(String value) {
        this.dbpath = value;
    }

    /**
     * ��ȡformname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFORMNAME() {
        return formname;
    }

    /**
     * ����formname���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFORMNAME(String value) {
        this.formname = value;
    }

    /**
     * ��ȡcreateren���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCREATEREN() {
        return createren;
    }

    /**
     * ����createren���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCREATEREN(String value) {
        this.createren = value;
    }

    /**
     * ��ȡcreatercn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCREATERCN() {
        return creatercn;
    }

    /**
     * ����creatercn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCREATERCN(String value) {
        this.creatercn = value;
    }

    /**
     * ��ȡapproveren���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPPROVEREN() {
        return approveren;
    }

    /**
     * ����approveren���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPPROVEREN(String value) {
        this.approveren = value;
    }

    /**
     * Gets the value of the filedlist property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filedlist property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFILEDLIST().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FIELDINFOCLASS }
     * 
     * 
     */
    public List<FIELDINFOCLASS> getFILEDLIST() {
        if (filedlist == null) {
            filedlist = new ArrayList<FIELDINFOCLASS>();
        }
        return this.filedlist;
    }

    /**
     * ��ȡtonodeid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTONODEID() {
        return tonodeid;
    }

    /**
     * ����tonodeid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTONODEID(String value) {
        this.tonodeid = value;
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

    /**
     * ��ȡmsgsubject���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGSUBJECT() {
        return msgsubject;
    }

    /**
     * ����msgsubject���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGSUBJECT(String value) {
        this.msgsubject = value;
    }

    /**
     * ��ȡflowkey���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFLOWKEY() {
        return flowkey;
    }

    /**
     * ����flowkey���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFLOWKEY(String value) {
        this.flowkey = value;
    }

}
