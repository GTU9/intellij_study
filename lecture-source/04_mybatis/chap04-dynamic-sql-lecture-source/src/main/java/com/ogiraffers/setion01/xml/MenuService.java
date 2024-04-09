package com.ogiraffers.setion01.xml;

import org.apache.ibatis.session.SqlSession;

import static com.ogiraffers.common.Template.getSqlSession;

public class MenuService {

    private DynamicSqlMapper mapper;
    public void selectMenuByPrice(int price) {
        SqlSession sqlSession=getSqlSession();
        mapper=sqlSession.getMapper(DynamicSqlMapper.class);
    }
}
