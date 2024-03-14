package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class A_for {

    public void testSimpleForStatmement(){

        /*for문 단독 사용에 대한 흐름을 이해하고 적용할 수 있다.*/
        /*[for문 표현식]
        * for(초기식; 조건식; 증감식){
        *       조건을 만족하는 경우 수행할 구문(반복할 구문)
        * }
        * */

        /*1부터 10까지 1씩 증가시키면서 (10번) i값을 출력하는 기본 반복문*/
        for(int i=1;i<=10;i++){
            System.out.println(i);
        }
        /* 기본 반복문을 이요해서 조금씩 바꿔가며 우선 문법을 익숙해지도록 하자
         * 1. 증감식이 없는 경우
         * 2. 조건식이 없는 경우
         * 3. 초기식, 조건식, 증감식이 없는 경우
         * 4. 초기식, 조건식, 증감식 등을 변경하고 실행 값 예측해보기
         * 5. 역순으로 반복된 실행
         * 등등 필요에 따라 더 기본 반복문을 변형해가며 테스트 해보자
         * */
    }

    public void testForExample(){
        /*무엇을 반복하는지를 확인하여 반복문으로 개선할 수 있다. (1)*/

        /*10명의 학생 이름을  입력받아 출력해보자*/
        /*반복해야 할 내용이 무엇인지와 몇번 반복해야 하는지를 확인해보자!*/
        Scanner sc= new Scanner(System.in);

        System.out.print("1 번째 학생의 이름을 입력해주세요 : ");
        String student1 =sc.nextLine();
        System.out.println("1번째 학생의 이름은 " +student1+"입니다.");

        System.out.print("2 번째 학생의 이름을 입력해주세요 : ");
        String student2 =sc.nextLine();
        System.out.println("2번째 학생의 이름은 " +student2+"입니다.");

        System.out.print("3 번째 학생의 이름을 입력해주세요 : ");
        String student3 =sc.nextLine();
        System.out.println("3번째 학생의 이름은 " +student3+"입니다.");

        System.out.print("4 번째 학생의 이름을 입력해주세요 : ");
        String student4 =sc.nextLine();
        System.out.println("4번째 학생의 이름은 " +student4+"입니다.");

        System.out.print("5 번째 학생의 이름을 입력해주세요 : ");
        String student5 =sc.nextLine();
        System.out.println("5번째 학생의 이름은 " +student5+"입니다.");

        System.out.print("6 번째 학생의 이름을 입력해주세요 : ");
        String student6 =sc.nextLine();
        System.out.println("6번째 학생의 이름은 " +student6+"입니다.");

        System.out.print("7 번째 학생의 이름을 입력해주세요 : ");
        String student7 =sc.nextLine();
        System.out.println("7번째 학생의 이름은 " +student7+"입니다.");

        System.out.print("8 번째 학생의 이름을 입력해주세요 : ");
        String student8 =sc.nextLine();
        System.out.println("8번째 학생의 이름은 " +student8+"입니다.");

        System.out.print("9 번째 학생의 이름을 입력해주세요 : ");
        String student9 =sc.nextLine();
        System.out.println("1번째 학생의 이름은 " +student9+"입니다.");

        System.out.print("10 번째 학생의 이름을 입력해주세요 : ");
        String student10 =sc.nextLine();
        System.out.println("10번째 학생의 이름은 " +student10+"입니다.");

        System.out.println("10명의 학생 이름을 입력 받고 출력하는 기능을 완료했습니다!!");

        /*반복해야 하는 내용은
         * 1. 안내문구 출력
         * 2.학생 이름을 입력 받아 변수에 저장
         * 3. 저장된 이름을 출력
         *
         * 반복 횟수는 1부터 10까지 1씩 증가하며 총 10번을 반복한다.
         * */

        /*반복문으로 개선*/
        for(int i=1;i<=10;i++){
            System.out.print(i+"번째 학생의 이름을 입력해주세요 : ");
            String student =sc.nextLine();
            System.out.println(i+"번째 학생의 이름은 " +student+"입니다.");
        }

        System.out.println("10의 학생 이름을 입력 받고 출력하는 기능을 완료했습니다!!");

        /*1. 보다 간결하게 코드가 작성되었다. (가독성)
        * 2. 학생의 이름 뿐 아니라 성적도 입력하는 기능이 추가된다면? (유지보수성)
        * */
    }

    public void testForExample2(){
        /*무엇을 반복하는지를 화인하여 반복문으로 개선할 수 있다. (2)*/

        /*문자 속에서 규칙 찾기
        * 1~10까지의 합계를 구하시오
        * */

        /*이렇게만 작성되어 있으면 처음 프로그래밍 하는 사람에게는 꽤나 난감하다.
        * 어느 정ㄷ 익숙한 사람에게는 저 문제에서 해결해야 하는 내용과 규칙이 머릿속에 자연스럽게 그려지지만
        * 처음 접하는 사람한테는 그렇지 않다.
        * 단계적으로 접근할 수 있도록 위의 내용을 좀 풀어서 다시 작성해본다면
        * 1부터 10까지 1씩 증가시키면서 값을 저장할 변수에 계속 누적시켜 변수에 저장된 값을 출력하세요 가 된다.
        * */

        /*1부터 10까지를 변수에 저장*/
        int num1=1;
        int num2=2;
        int num3=3;
        int num4=4;
        int num5=5;
        int num6=6;
        int num7=7;
        int num8=8;
        int num9=9;
        int num10=10;

        /*결과를 누적시켜 담을수 있는 변수 선언*/
        /*더한 값을 누적시킬 변수는 통상 0으로 초기화 시킨다.*/

        int sum=0;

        /*sum에 값 하나씩 담기*/
        sum+=num1;
        sum+=num2;
        sum+=num3;
        sum+=num4;
        sum+=num5;
        sum+=num6;
        sum+=num7;
        sum+=num8;
        sum+=num9;
        sum+=num10;

        /*저장된 값 출력*/
        System.out.println("sum : "+sum);

        int sum2=0;
        for(int i=1;i<=10;i++){
            sum2+=i;
        }
        System.out.println("sum2 : "+sum2);
    }

    public void testForExample3(){

        int random= (int) (Math.random()*6)+5;
        System.out.println("random : " +random);

        /*뭔가 더 담기 위해 sum 변수를 0으로 초기화*/
        int sum=0;

        /*발생한 난수에 따라 더하는 숫자가 달라지기 때문에 조건문을 이용해서 처리해보자*/
        if(random==5){
            sum+=1;
            sum+=2;
            sum+=3;
            sum+=4;
            sum+=5;

        }
        if(random==6){
            sum+=1;
            sum+=2;
            sum+=3;
            sum+=4;
            sum+=5;
            sum+=6;
        }
        if(random==7){
            sum+=1;
            sum+=2;
            sum+=3;
            sum+=4;
            sum+=5;
            sum+=6;
            sum+=7;
        }
        if(random==8){
            sum+=1;
            sum+=2;
            sum+=3;
            sum+=4;
            sum+=5;
            sum+=6;
            sum+=7;
            sum+=8;
        }
        if(random==9){
            sum+=1;
            sum+=2;
            sum+=3;
            sum+=4;
            sum+=5;
            sum+=6;
            sum+=7;
            sum+=8;
            sum+=9;
        }
        if(random==10){
            sum+=1;
            sum+=2;
            sum+=3;
            sum+=4;
            sum+=5;
            sum+=6;
            sum+=7;
            sum+=8;
            sum+=9;
            sum+=10;

        }
    }
}
