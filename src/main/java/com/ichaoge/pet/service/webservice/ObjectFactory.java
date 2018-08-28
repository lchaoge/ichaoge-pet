
package com.ichaoge.pet.service.webservice;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.wm.oa.domain.rpc package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wm.oa.domain.rpc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FIELDINFOCLASS }
     * 
     */
    public FIELDINFOCLASS createFIELDINFOCLASS() {
        return new FIELDINFOCLASS();
    }

    /**
     * Create an instance of {@link PROCESSSTAT }
     * 
     */
    public PROCESSSTAT createPROCESSSTAT() {
        return new PROCESSSTAT();
    }

    /**
     * Create an instance of {@link DIGIFLOWPARA }
     * 
     */
    public DIGIFLOWPARA createDIGIFLOWPARA() {
        return new DIGIFLOWPARA();
    }

    /**
     * Create an instance of {@link BACKFLOWPARAS }
     * 
     */
    public BACKFLOWPARAS createBACKFLOWPARAS() {
        return new BACKFLOWPARAS();
    }

    /**
     * Create an instance of {@link RETURNINFO }
     * 
     */
    public RETURNINFO createRETURNINFO() {
        return new RETURNINFO();
    }

}
