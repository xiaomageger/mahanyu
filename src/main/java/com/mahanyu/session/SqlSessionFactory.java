package com.mahanyu.session;

/**
 * Created by 小马哥 on 2019/8/27.
 */

//用于创建sqlSession对象的接口
public interface SqlSessionFactory {

    SqlSession openSqlSession();

}
