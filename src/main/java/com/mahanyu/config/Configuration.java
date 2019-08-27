package com.mahanyu.config;

/**
 * Created by 小马哥 on 2019/8/27.
 */

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

/**
 *  配置文件的解析封装类
 */
public class Configuration {


    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
