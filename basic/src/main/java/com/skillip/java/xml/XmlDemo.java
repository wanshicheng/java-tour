package com.skillip.java.xml;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 * xpath的文档：https://www.w3.org/TR/xpath/
 */
public class XmlDemo {
    public static void main(String[] args) throws Exception {
        System.out.println();
        InputStream is = XmlDemo.class.getClassLoader().getResourceAsStream("data/book.xml");
        SAXReader reader = new SAXReader();
        Document doc = reader.read(is);
        String xpath = "/config/cooperator/comefrom/key";
        System.out.println(doc.selectSingleNode(xpath).asXML());
        System.out.println(doc.selectSingleNode(xpath).getStringValue());
        System.out.println(doc.selectSingleNode(xpath).getText());

    }
}
