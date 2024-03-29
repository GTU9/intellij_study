package com.ohgiraffers.section01.statement;

import com.ohgiraffers.domain.entity.Empolyee;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("조회하실 사번을 입력하세요 : ");
        String empId=sc.nextLine();

        FindOneEmployeeService service =new FindOneEmployeeService();
        Empolyee foundEmployee=service.findEmployeeByEmpId(empId);

        System.out.println("foundEmployee ="+foundEmployee);
    }
}
