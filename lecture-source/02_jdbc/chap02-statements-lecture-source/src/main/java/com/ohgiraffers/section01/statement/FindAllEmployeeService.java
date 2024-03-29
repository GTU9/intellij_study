package com.ohgiraffers.section01.statement;

import com.ohgiraffers.domain.entity.Empolyee;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class FindAllEmployeeService {

    public List<Empolyee> findAllEmployees(){

        Connection con =getConnection();

        EmployeeRepository repository=new EmployeeRepository();
        List<Empolyee> empolyees=repository.findAllEmployees(con);

        close(con);
        return empolyees;

    };
}
