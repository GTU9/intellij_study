package com.ohgiraffers.section01.statement;

import com.ohgiraffers.domain.entity.Empolyee;

import java.util.List;

public class Application4 {
    public static void main(String[] args) {

        FindAllEmployeeService service = new FindAllEmployeeService();
        List<Empolyee> empolyees=service.findAllEmployees();

        empolyees.forEach(System.out::println);

    }
}
