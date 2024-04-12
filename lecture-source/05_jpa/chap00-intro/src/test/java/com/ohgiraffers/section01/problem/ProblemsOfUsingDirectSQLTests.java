package com.ohgiraffers.section01.problem;

import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProblemsOfUsingDirectSQLTests {

    private Connection con;

    @BeforeEach
    void setConnection() throws ClassNotFoundException, SQLException {
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/menu";
        String user="sahmyook";
        String password="sahmyook";

        Class.forName(driver);

        con= DriverManager.getConnection(url,user,password);
        con.setAutoCommit(false);
    }
    @AfterEach
    void closeConnection() throws SQLException {
        con.rollback();
        con.close();
    }

    /*
    * [JDBC API를 이용해 직접 SQL을 다룰 때 발생할 수 있는 문제점]
    * 1. 데이터 변환, SQL 작성, JDBC API 코드 등을 중복 작성(= 개발시간 증가, 유지보수성 약화)
    * 2. SQL 의존적인 개발
    * 3. 패러다임 불일치 문제 (상속, 연관관계, 객체 그래프 탐색)
    * 4. 동일성 보장 문제
    * */

    @Test
    @DisplayName("직접 SQL을 작성하여 메뉴를 조회할 때 발생하는 문제 확인")
    void testDirectSselectSQL() throws SQLException {
        //given
        String query="SELECT MENU_CODE, MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS from tbl_menu";

        //when
        Statement stmt=con.createStatement();
        ResultSet rset=stmt.executeQuery(query);

        List<Menu> menuList=new ArrayList<Menu>();
        while(rset.next()){
            Menu menu=new Menu();
            menu.setMenuCode(rset.getInt("MENU_CODE"));
            menu.setMenuName(rset.getString("MENU_NAME"));
            menu.setMenuCode(rset.getInt("MENU_PRICE"));
            menu.setMenuCode(rset.getInt("CATEGORY_CODE"));
            menu.setMenuName(rset.getString("ORDERABLE_STATUS"));

            menuList.add(menu);
        }

        //then
        Assertions.assertNotNull(menuList);

        rset.close();
        stmt.close();
    }
    @Test
    @DisplayName("직접 SQL을 작성하여 신규 메뉴 추가 시 발생하는 문제 확인")
    void testDirectInsertSQL() throws SQLException {
        Menu menu=new Menu();
        menu.setMenuName("고등어단백질쉐이크");
        menu.setMenuPrice(120000);
        menu.setCategoryCode(1);
        menu.setOrderableStatus("Y");

        String query="insert into tbl_menu(menu_name, menu_price, category_code, orderable_status) values(?,?,?,?)";

        //when
        PreparedStatement pstmt=con.prepareStatement(query);
        pstmt.setString(1, menu.getMenuName());
        pstmt.setInt(2,menu.getMenuPrice());
        pstmt.setInt(3,menu.getCategoryCode());
        pstmt.setString(4, menu.getOrderableStatus());

        int result=pstmt.executeUpdate();

        //then
        Assertions.assertEquals(1,result);

        pstmt.close();
    }

    /* 2. SQL 의존적인 개발*/
    /* 2-1. 조회 항목 변경에 따른 의존성 */
    @Test
    @DisplayName("조회 항목 변경에 따른 의존성 확인")
    void testChangeSelectColums() throws SQLException {
        //given
        String query = "select menu_code, menu_name from tbl_menu";

        //when
        Statement stmt=con.createStatement();
        ResultSet rset=stmt.executeQuery(query);

        List<Menu> menuList=new ArrayList<>();
        while (rset.next()){
            Menu menu=new Menu();
            menu.setMenuCode(rset.getInt("menu_code"));
            menu.setMenuName(rset.getString("menu_name"));
//            menu.setMenuPrice(rset.getInt("menu_price"));
        }

        //then
        Assertions.assertNotNull(menuList);

        rset.close();
        stmt.close();
    }

    /* 2-2. 연관된 객체 문제*/
    void testAssociateObject() throws SQLException {
        //given
        String query = "select menu_code, menu_name, menu_price, category_code, category_name, orderable_status" +
                "from tbl_menu a" +
                "join tbl_category b on (a.category_code=b.category_code)";

        //when
        Statement stmt=con.createStatement();
        ResultSet rset=stmt.executeQuery(query);

        List<MenuAndCategory> menuAndCategories=new ArrayList<>();
        while (rset.next()) {
            MenuAndCategory menuAndCategory=new MenuAndCategory();
            menuAndCategory.setMenu_code(rset.getInt("menu_code"));
            menuAndCategory.setMenu_name(rset.getString("menu_name"));
            menuAndCategory.setMenu_price(rset.getInt("menu_price"));
            menuAndCategory.setCategory(new Category(rset.getString("category_name"), rset.getInt("category_code")));
            menuAndCategory.setOrderableStatus(rset.getString("orderable_status"));

            menuAndCategories.add(menuAndCategory);
        }

        Assertions.assertNotNull(menuAndCategories);

        rset.close();
        stmt.close();


        //then
    }
}
