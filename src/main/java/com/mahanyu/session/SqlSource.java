package com.mahanyu.session;

/**
 * Created by 小马哥 on 2019/8/27.
 */

/**
 *
 */
public class SqlSource {

    private String sqlText;

    public SqlSource(String sqlText) {
        this.sqlText = sqlText;
    }

    public String getSqlText() {
        return sqlText;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }

    public BoundSql getBoundSql(){
        return new BoundSql(sqlText);
    }
}
