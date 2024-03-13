package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class C_ifElseif {

    public void testSimpleIfElseIfStatement(){
        /*if-else-if 문 단독 사용에 대한 흐름을 이해하고 적용할 수 있다.*/

        /*[if-else-if문 표현식]
        * if(조건식1){
        *   조건식1이 true일 때 실행할 명령문;
        * }else if(조건식2){
        *   조건식1이 false이고 조건식2가 true일 때 실행할 명령문;
        * }else {
        *   위의 조건 2개가 모두 거짓인 경우 실행할 명령문;
        * }
        * */

        /*if-else-if문은 조건식1의 결과 같이 참(true)이면  if{ }안에 있는 코드를 실행하고,
        * 조건식1이 false이면 조건2를 확인하여 참(true)이면 else if { }안에 있는 코드를 실행한다.
        * 조건식1, 2의 결과 값이 모두 거짓(false)이면 else{ } 안에 있는 코드를 실행한다.
        * */

        /*여럭 개의 조건을 제시하여 그 중 한가지를 반드시 실행시키고 싶은 경우 사용한다.*/

        /*금도끼 은도끼 동화에서 산신령이 어떤 도끼가 나무꾼의 도끼인지 물어보는 시나리오대로 코드를 작성하고 실행해보자! */

        System.out.println("산 속에서 나무를 하던 나무꾼이 연못에 도끼를 빠드리고 말았따.");
        System.out.println("연못에서 산신령이 나타나 금도끼, 은도끼, 쇠도끼를 들고 나타났다.");
        System.out.println("나문꾼에게 셋중 어떤 도기끼가 나무꾼의 도끼인지 물어보았다.");

        /*문자열을 비교하난 equals()를 사용해 문자열로 입력을 받아도 된다.*/
        System.out.println("어느 도끼가 너의 도끼이냐? (1. 금도끼, 2. 은도끼, 3.쇠도끼) : ");
        Scanner sc= new Scanner(System.in);
        int answer= sc.nextInt();

        /* 대답한 내용이 금도끼인지 확인하는 조건식 */
        if(answer == 1) {

            /* 금도끼라고 대답한 경우 출력할 내용 */
            System.out.println("이런 거짓말 쟁이!! 너에게는 아무런 도끼도 줄 수 없구나!! 이 욕심쟁이야!!");

            /* 대답한 내용이 은도끼인지 확인하는 조건식 */
        } else if(answer == 2) {

            /* 은도끼라고 대답한 경우 출력할 내용 */
            System.out.println("욕심이 과하지는 않지만 그래도 넌 거짓말을 하고 있구나!! 어서 썩 사라지거라!!");

            /* 위에 제시한 금도끼, 은도끼 둘 다 아닌 경우(즉, 쇠도끼인 경우)*/
        } else {

            /* 쇠도끼라고 대답한 경우 출력할 내용 */
            System.out.println("오호~ 정직하구나~ 여기 있는 금도끼, 은도끼, 쇠도끼 다 가져가거라!!");
        }

        /* 대답 여부와 상관 없이 마지막에 실행하는 내용 */
        System.out.println("그렇게 산신령은 다시 연못 속으로 사라지고 말았다...");
    }
}
