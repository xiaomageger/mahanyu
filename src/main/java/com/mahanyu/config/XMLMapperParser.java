package com.mahanyu.config;

/**
 * Created by 小马哥 on 2019/8/27.
 */

import org.dom4j.Document;
import org.dom4j.Element;

import java.io.InputStream;
import java.util.List;

/**
 *  mapper文件解析器
 */
public class XMLMapperParser {

    private String nameSpace;

    public void parserMapper(Element element){
        List<Element> mapperList = element.elements("mapper");
        for (Element mapper : mapperList) {
            String resource = mapper.attributeValue("resource");
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(resource);
            Document document = DocumentReader.createDocument(resourceAsStream);
            parseStatements(document);
        }

    }

    private void parseStatements(Document document) {
        Element rootElement = document.getRootElement();
        //获取mapper的命名空间
        nameSpace = rootElement.attributeValue("nameSpace");

        List<Element> selectList = rootElement.elements("select");
        for (Element element : selectList) {
            String id = element.attributeValue("id");
            String statementType = element.attributeValue("statementType");
            String parameterType = element.attributeValue("parameterType");
            Class<?> parameterTypeClass = getClassType(parameterType);
            String resultType = element.attributeValue("resultType");
            Class<?> resultTypeClass = getClassType(resultType);

            String sqlText = element.getTextTrim();
        }

    }

    private Class<?> getClassType(String parameter){
        Class<?> parameterClazz = null;
        try {
            parameterClazz = Class.forName(parameter);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return parameterClazz;
    }

}
