package com.ohgiraffers.section01.statement;

import com.ohgiraffers.common.JDBCTemplate;
import com.ohgiraffers.domain.entity.Empolyee;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class FindOneEmployeeService {

    public Empolyee findEmployeeByEmpId(String empId){

        Connection con= JDBCTemplate.getConnection();

        EmployeeRepository repository=new EmployeeRepository();

        Empolyee foundEmployee= repository.findEmployeeByEmpId(con,empId);

        close(con);

        return foundEmployee;
    }
}
