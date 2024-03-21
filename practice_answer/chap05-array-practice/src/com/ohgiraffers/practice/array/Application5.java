package com.ohgiraffers.practice.array;

import java.util.Scanner;

public class Application5 {

    public static void main(String[] args) {

        /* 1. 홀수인 양의 정수를 입력 받아
         * 2. 입력받은 크기 만큼의 정수형 배열을 할당하고
         * 3. 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고
         * 4. 중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
         *
         * 단, 홀수인 양의 정수를 입력하지 않은 경우에는 "홀수인 양수만 입력해야 합니다."를 출력하세요
         *
         * -- 입력 예시 --
         * 홀수인 양의 정수를 입력하세요 : 7
         *
         * -- 출력 예시 --
         * 1 2 3 4 3 2 1
         *
         * -- 입력 예시 --
         * 홀수인 양의 정수를 입력하세요 : 8
         *
         * -- 출력 예시 --
         * 양수 혹은 홀수만 입력해야 합니다.
         */

        Scanner sc= new Scanner(System.in);
        System.out.print("홀수인 양의 정수를 입력하세요 : ");
        int num = sc.nextInt();
        if(num%2==1&&num>0){
            int[] narr=new int[num];
            for(int i=0;i<num;i++){
                if(i<= num/2){
                    narr[i]=i+1;
                }else {
                    narr[i]=num-i;
                }
                System.out.print(narr[i]+" ");
            }
        }else {
            System.out.println("양수 혹은 홀수만 입력해야 합니다.");
        }
    }

}
//9
//1 2 3 4 5 6 7 8 9
//1 2 3 4 5 4 3 2 1