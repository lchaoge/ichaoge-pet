package com.ichaoge.pet.sax;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;
import java.util.Map.Entry;


/**
 * @author Satyendra Gurjar
 *
 */
public class SAXHandler extends DefaultHandler
{
    public static final String CVSKeywords = "@(#) RcsModuleId = $Id:$ $Name:$";

    /*
     * Internal Element used for sax parsing
     */
    private static class InternalElement
    {
        String          name;
        StringBuffer    value;
        ArrayList       children;
        InternalElement parent;
        String          namespaceUri;
    }

    /*
     * trim leading and trailing white spaces from the value of xml tags.
     */
    private boolean trimWhitespaces = true;

    /*
     * element hold the root element after parsing is done.
     */
    private InternalElement currentElement;

    public SAXHandler()
    {
    }

    public SAXHandler(boolean trimWhitespaces)
    {
        this.trimWhitespaces        = trimWhitespaces;
    }

    public Map<String,Object> getMap()
    {
        Map<String,Object> out = new HashMap<String,Object>();
        
        Map<String,Object> value = null;
        
        createMap(currentElement, out);
        if (out!=null) {
            for (Entry<String, Object> o : out.entrySet()) {
                value = (Map<String,Object>)o.getValue();
            }
        }
        
        return value;
    }

    //处理多次调用，递归成员变量改为空时，不为空（后面的CreatMap()方法）
    //可以在文档开始的时候，或者结束的时候，清空成员变量
    @Override
    public void startDocument() throws SAXException {
        currentElement = null;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes)
        throws SAXException
    {
        InternalElement newElement = new InternalElement();
        newElement.name = localName;

        if (currentElement != null) {
            if (currentElement.children == null) {
                currentElement.children = new ArrayList();
            }

            currentElement.children.add(newElement);
        } else {
            // this is root element set namespace uri here
            // as we support only one namespace only at root level
            newElement.namespaceUri = StringUtils.trimToNull(uri);
        }

        newElement.parent     = currentElement;
        currentElement        = newElement;
    }

    public void characters(char[] ch, int start, int length)
        throws SAXException
    {
        if (currentElement.value == null) {
            currentElement.value = new StringBuffer();
        }

        currentElement.value.append(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName)
        throws SAXException
    {
        if (currentElement.parent != null) {
            currentElement = currentElement.parent;
        }
    }

    public void warning(SAXParseException e) throws SAXException
    {
        throw e;
    }

    public void error(SAXParseException e) throws SAXException
    {
        throw e;
    }

    public void fatalError(SAXParseException e) throws SAXException
    {
        throw e;
    }

    private void createMap(InternalElement element, Map<String,Object> out)
    {
        if (element == null) {
            throw new IllegalArgumentException("element is null");
        }

        if (out == null) {
            throw new IllegalArgumentException("out is null");
        }

        if (element.children == null) {
            put(out, element.name,
                (element.value != null) ? (trimWhitespaces ? element.value.toString().trim() : element.value.toString())
                                        : StringUtils.EMPTY_STR);
        } else {
            Map<String,Object> m = new HashMap();

            for (Iterator i = element.children.iterator(); i.hasNext();)
                createMap((InternalElement) i.next(), m);

            put(out, element.name, m);
        }
    }

    private void put(Map<String,Object> m, Object key, Object value)
    {
        Object o = m.get(key);

        if (o == null) {
            m.put(key+"", value);

            return;
        }

        if (o instanceof List) {
            ((List) o).add(value);

            return;
        }

        ArrayList l = new ArrayList();
        l.add(o);
        l.add(value);
        m.put(key+"", l);
    }
}
