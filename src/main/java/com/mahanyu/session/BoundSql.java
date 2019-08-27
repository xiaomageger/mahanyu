package com.mahanyu.session;

/**
 * Created by 小马哥 on 2019/8/27.
 */

import java.util.List;

/**
 *
 */
public class BoundSql {

    private String sqlText;

    private List<ParameterMapping> parameterMappingList;

    public BoundSql(String sqlText) {
        this.sqlText = sqlText;
    }

    public String getSqlText() {
        return sqlText;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }

    public List<ParameterMapping> getParameterMappingList() {
        return parameterMappingList;
    }

    public void addParameterMappingList(ParameterMapping parameterMapping) {
        this.parameterMappingList.add(parameterMapping);
    }
}
