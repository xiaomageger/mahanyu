package com.mahanyu.session;

/**
 * Created by 小马哥 on 2019/8/27.
 */
public interface SqlSession {

    <T> T selectOne();

}
