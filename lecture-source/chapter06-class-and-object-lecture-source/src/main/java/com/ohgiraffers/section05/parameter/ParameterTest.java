package com.ohgiraffers.section05.parameter;

public class ParameterTest {
    public void testPrimaryTypeParameter(int num){
        System.out.println("매개변수로 전달 받은 값 : "+num);
    }

    public void testPrimaryTypeParameter(int[] iarr){
        /*배열의 주소가 전달된다.
        * 즉 인자로 전달하는 배열과 매개변수로 전달받은 배열은 서로 동일한 배열을 가리킨다. (얕은복사)
        * */
        System.out.println("매개변수로 전달 받은 값 : "+iarr);

        /*배열의 값 출력*/
        System.out.println("배열의 값 출력 : ");
        for(int i=0;i<iarr.length;i++){
            System.out.print(iarr[i]+" ");
        }
        System.out.println();
    }
}
