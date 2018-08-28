
package com.ichaoge.pet.service.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BACKFLOWPARAS complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="BACKFLOWPARAS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="USERNAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PASSWORD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SERVERNAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DBPATH" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DOCUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UPDFIELDS" type="{urn:DefaultNamespace}FIELDINFOCLASS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OPTPSNID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PSNMIND" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OPTTYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TONODEID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MSGTITLE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MSGEXTEND1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MSGEXTEND2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MSGEXTEND3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MSGEXTEND4" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MSGEXTEND5" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MSGEXTEND6" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MSGEXTEND7" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MSGEXTEND8" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MSGEXTEND9" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MSGEXTEND10" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MOBILEFLAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TEMPAUTHORS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SELECTPSNS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BACKFLOWPARAS", propOrder = {
    "username",
    "password",
    "servername",
    "dbpath",
    "docuid",
    "updfields",
    "optpsnid",
    "psnmind",
    "opttype",
    "tonodeid",
    "msgtitle",
    "msgextend1",
    "msgextend2",
    "msgextend3",
    "msgextend4",
    "msgextend5",
    "msgextend6",
    "msgextend7",
    "msgextend8",
    "msgextend9",
    "msgextend10",
    "mobileflag",
    "tempauthors",
    "selectpsns"
})
public class BACKFLOWPARAS {

    @XmlElement(name = "USERNAME", required = true)
    protected String username;
    @XmlElement(name = "PASSWORD", required = true)
    protected String password;
    @XmlElement(name = "SERVERNAME", required = true)
    protected String servername;
    @XmlElement(name = "DBPATH", required = true)
    protected String dbpath;
    @XmlElement(name = "DOCUID", required = true)
    protected String docuid;
    @XmlElement(name = "UPDFIELDS", nillable = true)
    protected List<FIELDINFOCLASS> updfields;
    @XmlElement(name = "OPTPSNID", required = true)
    protected String optpsnid;
    @XmlElement(name = "PSNMIND", required = true)
    protected String psnmind;
    @XmlElement(name = "OPTTYPE", required = true)
    protected String opttype;
    @XmlElement(name = "TONODEID", required = true)
    protected String tonodeid;
    @XmlElement(name = "MSGTITLE", required = true)
    protected String msgtitle;
    @XmlElement(name = "MSGEXTEND1", required = true)
    protected String msgextend1;
    @XmlElement(name = "MSGEXTEND2", required = true)
    protected String msgextend2;
    @XmlElement(name = "MSGEXTEND3", required = true)
    protected String msgextend3;
    @XmlElement(name = "MSGEXTEND4", required = true)
    protected String msgextend4;
    @XmlElement(name = "MSGEXTEND5", required = true)
    protected String msgextend5;
    @XmlElement(name = "MSGEXTEND6", required = true)
    protected String msgextend6;
    @XmlElement(name = "MSGEXTEND7", required = true)
    protected String msgextend7;
    @XmlElement(name = "MSGEXTEND8", required = true)
    protected String msgextend8;
    @XmlElement(name = "MSGEXTEND9", required = true)
    protected String msgextend9;
    @XmlElement(name = "MSGEXTEND10", required = true)
    protected String msgextend10;
    @XmlElement(name = "MOBILEFLAG", required = true)
    protected String mobileflag;
    @XmlElement(name = "TEMPAUTHORS", required = true)
    protected String tempauthors;
    @XmlElement(name = "SELECTPSNS", required = true)
    protected String selectpsns;

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
     * ��ȡservername���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVERNAME() {
        return servername;
    }

    /**
     * ����servername���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVERNAME(String value) {
        this.servername = value;
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
     * ��ȡdocuid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDOCUID() {
        return docuid;
    }

    /**
     * ����docuid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDOCUID(String value) {
        this.docuid = value;
    }

    /**
     * Gets the value of the updfields property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the updfields property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUPDFIELDS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FIELDINFOCLASS }
     * 
     * 
     */
    public List<FIELDINFOCLASS> getUPDFIELDS() {
        if (updfields == null) {
            updfields = new ArrayList<FIELDINFOCLASS>();
        }
        return this.updfields;
    }

    /**
     * ��ȡoptpsnid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOPTPSNID() {
        return optpsnid;
    }

    /**
     * ����optpsnid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOPTPSNID(String value) {
        this.optpsnid = value;
    }

    /**
     * ��ȡpsnmind���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPSNMIND() {
        return psnmind;
    }

    /**
     * ����psnmind���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPSNMIND(String value) {
        this.psnmind = value;
    }

    /**
     * ��ȡopttype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOPTTYPE() {
        return opttype;
    }

    /**
     * ����opttype���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOPTTYPE(String value) {
        this.opttype = value;
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
     * ��ȡmsgtitle���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGTITLE() {
        return msgtitle;
    }

    /**
     * ����msgtitle���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGTITLE(String value) {
        this.msgtitle = value;
    }

    /**
     * ��ȡmsgextend1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGEXTEND1() {
        return msgextend1;
    }

    /**
     * ����msgextend1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGEXTEND1(String value) {
        this.msgextend1 = value;
    }

    /**
     * ��ȡmsgextend2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGEXTEND2() {
        return msgextend2;
    }

    /**
     * ����msgextend2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGEXTEND2(String value) {
        this.msgextend2 = value;
    }

    /**
     * ��ȡmsgextend3���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGEXTEND3() {
        return msgextend3;
    }

    /**
     * ����msgextend3���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGEXTEND3(String value) {
        this.msgextend3 = value;
    }

    /**
     * ��ȡmsgextend4���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGEXTEND4() {
        return msgextend4;
    }

    /**
     * ����msgextend4���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGEXTEND4(String value) {
        this.msgextend4 = value;
    }

    /**
     * ��ȡmsgextend5���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGEXTEND5() {
        return msgextend5;
    }

    /**
     * ����msgextend5���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGEXTEND5(String value) {
        this.msgextend5 = value;
    }

    /**
     * ��ȡmsgextend6���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGEXTEND6() {
        return msgextend6;
    }

    /**
     * ����msgextend6���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGEXTEND6(String value) {
        this.msgextend6 = value;
    }

    /**
     * ��ȡmsgextend7���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGEXTEND7() {
        return msgextend7;
    }

    /**
     * ����msgextend7���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGEXTEND7(String value) {
        this.msgextend7 = value;
    }

    /**
     * ��ȡmsgextend8���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGEXTEND8() {
        return msgextend8;
    }

    /**
     * ����msgextend8���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGEXTEND8(String value) {
        this.msgextend8 = value;
    }

    /**
     * ��ȡmsgextend9���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGEXTEND9() {
        return msgextend9;
    }

    /**
     * ����msgextend9���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGEXTEND9(String value) {
        this.msgextend9 = value;
    }

    /**
     * ��ȡmsgextend10���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGEXTEND10() {
        return msgextend10;
    }

    /**
     * ����msgextend10���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGEXTEND10(String value) {
        this.msgextend10 = value;
    }

    /**
     * ��ȡmobileflag���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMOBILEFLAG() {
        return mobileflag;
    }

    /**
     * ����mobileflag���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMOBILEFLAG(String value) {
        this.mobileflag = value;
    }

    /**
     * ��ȡtempauthors���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTEMPAUTHORS() {
        return tempauthors;
    }

    /**
     * ����tempauthors���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTEMPAUTHORS(String value) {
        this.tempauthors = value;
    }

    /**
     * ��ȡselectpsns���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSELECTPSNS() {
        return selectpsns;
    }

    /**
     * ����selectpsns���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSELECTPSNS(String value) {
        this.selectpsns = value;
    }

}
