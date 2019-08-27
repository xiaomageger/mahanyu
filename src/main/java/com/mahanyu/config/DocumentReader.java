package com.mahanyu.config;

/**
 * Created by 小马哥 on 2019/8/27.
 */

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jaxen.XPath;

import java.io.InputStream;

/**
 *  创建一个用来生成document的对象
 */
public class DocumentReader {

    public static Document createDocument(InputStream inputStream){

        Document document = null;

        SAXReader saxReader = new SAXReader();
        try {
            document = saxReader.read(inputStream);
            return document;
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return null;
    }

}
