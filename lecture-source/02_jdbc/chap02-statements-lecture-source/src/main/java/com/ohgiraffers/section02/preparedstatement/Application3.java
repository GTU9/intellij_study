package com.ohgiraffers.section02.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application3 {
    public static void main(String[] args) {

        /* 1. Connection 생성 */
        Connection con = getConnection();
        /* 2. PreparedStatement, ResultSet 생성 */
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        /* 3. Scanner를 활용하여 조회할 사번 입력받기 */
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 사번을 입력하세요 : ");
        int empId = sc.nextInt();
        /* 4. 조회를 위한 쿼리 작성 (placeholder 사용) */
        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID=?";
        /* 5. prepareStatement 생성 및 쿼리 준비 */
        try {
            pstmt = con.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /* 6. 조건에 해당하는 사번 세팅 */
        try {
            pstmt.setInt(1, empId);
            rset = pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /* 7. ResultSet에 존재하는 결과값을 출력 */
        try {
            if (rset.next()) {
                System.out.println("사원번호 = "+rset.getString("EMP_ID") +"\n사원이름 = "+rset.getString("EMP_NAME"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /* 8. 자원 반납 */
        close(rset);
        close(pstmt);
        close(con);

    }
}
