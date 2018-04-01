package com.wemall.uc.api;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



public class XMLHelper {
    public static LinkedList<String> uc_unserialize(String input) {
        LinkedList<String> result = new LinkedList<String>();
        SAXReader reader = new SAXReader();
        try {
            org.dom4j.Document document = reader.read(new StringReader(input));
            org.dom4j.Element root = document.getRootElement();
            List<Element> list = root.elements();

            for (Element ele : list)
                if (ele.getNodeType() == 1)
                    result.add(ele.getText());

        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
        }
        return result;
    }
}




