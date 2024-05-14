package com.ohgiraffers.section02.initdestroy.sub02.annotation;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context= new AnnotationConfigApplicationContext(ContextConfiguration.class);

        Product carpBread=context.getBean("carpBread", Bread.class);
        Product milk=context.getBean("milk", Beverage.class);
        Product water=context.getBean("water", Beverage.class);


        /*1. 첫 번째 손님이 카드를 꺼낸다.*/
        ShoppingCart cart1=context.getBean("cart", ShoppingCart.class);

        /*2. 붕어빵과 초코우유를 담는다.*/
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println("[cart1의 내용]"+cart1.getItems());

        /*3. 두 번째 손님이 쇼핑 카트를 꺼낸다.*/
        ShoppingCart cart2=context.getBean("cart", ShoppingCart.class);

        /*4. 지리산암반수를 담는다.*/
        cart2.addItem(water);

        System.out.println("[cart2의 내용]"+cart2.getItems());

        ((AnnotationConfigApplicationContext) context).close();  //컨테이너 강제 종료


    }
}
