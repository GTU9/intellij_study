package com.ohgiraffers.section03.branching;

import com.ohgiraffers.section02.looping.B_while;

public class Application {
    public static void main(String[] args) {
        A_break a= new A_break();
//        a.testSimpleBreakStatement();
//        a.testSimpleBreakStatement2();
//        a.testJumpBreak();
        B_continue b=new B_continue();
//        b.testSimpleContinueStatement();
//        b.testSimpleContinueStatement2();
        b.testJumpContinue();
    }
}
