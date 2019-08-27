package com.mahanyu.session;

/**
 * Created by 小马哥 on 2019/8/27.
 */


import org.apache.ibatis.parsing.GenericTokenParser;
import org.apache.ibatis.parsing.TokenHandler;

/**
 *  解析占位符
 */
public class ParseToken {

    public BoundSql parse(String sqlText){

// 解析sql文本
        ParameterMappingTokenHandler tokenHandler = new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", tokenHandler);
        String sql = genericTokenParser.parse(sqlText);

        BoundSql boundSql = new BoundSql(sql);

        return boundSql;
    }

}
