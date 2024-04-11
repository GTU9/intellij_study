package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {

    private DynamicSqlMapper mapper;

    public void selectMenuByPrice(int price) {
        SqlSession sqlSession=getSqlSession();
        mapper=sqlSession.getMapper(DynamicSqlMapper.class);
        Map<String, Integer> map=new HashMap<>();
        map.put("price",price);

        List<MenuDTO> menuList=mapper.selectMenuByPrice(map);

        sqlSession.close();

        if(menuList != null && menuList.size()>0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
    }

    public void searchMenu(SearchCriteria searchCriteria){
        SqlSession sqlSession=getSqlSession();
        mapper= sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList =mapper.searchMenu(searchCriteria);

        sqlSession.close();

        if(menuList != null && menuList.size()>0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {

        SqlSession sqlSession=getSqlSession();
        mapper=sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList=mapper.searchMenuBySupCategory(searchCriteria);

        sqlSession.close();

        if(menuList != null && menuList.size()>0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
    }


    public void searchMenuByRandomMenuCode(List<Integer> randomMenuCodeList) {
        SqlSession sqlSession=getSqlSession();
        mapper=sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, List<Integer>> criteria=new HashMap<>();
        criteria.put("randomMenuCodeList",randomMenuCodeList);

        List<MenuDTO> menuList=mapper.searchMenuByRandomMenuCode(criteria);

        sqlSession.close();

        if(menuList != null && menuList.size()>0){
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        }else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
    }
}
