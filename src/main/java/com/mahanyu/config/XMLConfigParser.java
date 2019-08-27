package com.mahanyu.config;

/**
 * Created by 小马哥 on 2019/8/27.
 */

import org.apache.commons.dbcp.BasicDataSource;
import org.dom4j.Document;
import org.dom4j.Element;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

/**
 * 全局配置文件解析类
 */
public class XMLConfigParser {


    //将全局配置文件 读成流文件
    private final String resource = "SqlMapConfig.xml";
    private Configuration configuration;

    private InputStream getInputStream(String resource) {
        return this.getClass().getClassLoader().getResourceAsStream(resource);
    }

    void configParser(InputStream inputStream) {

        Document document = DocumentReader.createDocument(inputStream);
        Element rootElement = document.getRootElement();
        parseEnvironments(rootElement);
        parseMappers(rootElement);

    }

    private void parseMappers(Element rootElement) {
        Element mappers = rootElement.element("mappers");
        new XMLMapperParser().parserMapper(mappers);
    }

    private void parseEnvironments(Element rootElement) {
        Element environments = rootElement.element("environments");
        String defaultId = environments.attributeValue("default");
        List<Element> environmentList = environments.elements("environment");
        for (Element element : environmentList) {
            String id = element.attributeValue("id");
            if (defaultId.equals(id)) {
                parseDataSource(element);
            }
        }
    }

    private void parseDataSource(Element element) {
        Element dataSource = element.element("dataSource");
        String type = dataSource.attributeValue("type");
        if (type == null || "".equals(type)) {
            type = "DBCP";
        }

        BasicDataSource basicDataSource = null;
        List<Element> propertieList = dataSource.elements("property");
        Properties properties = new Properties();
        for (Element property : propertieList) {
            String name = property.attributeValue("name");
            String value = property.attributeValue("value");
            properties.setProperty(name, value);
        }
        basicDataSource.setDriverClassName(properties.getProperty("driver"));
        basicDataSource.setPassword(properties.getProperty("password"));
        basicDataSource.setUsername(properties.getProperty("username"));
        basicDataSource.setUrl(properties.getProperty("url"));

        configuration.setDataSource(basicDataSource);
    }

}
