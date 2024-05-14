package com.ohgiraffer.section02.initdestroy.sub01.java;

import com.ohgiraffer.common.Beverage;
import com.ohgiraffer.common.Bread;
import com.ohgiraffer.common.Product;
import com.ohgiraffer.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfiguration {

    @Bean
    public Product carpBread(){
        return new Bread("붕어빵", 1500, new java.util.Date());
    }

    @Bean
    public Product milk(){
        return new Beverage("초코우유",1800, 300);
    }

    @Bean
    public Product water(){
        return new Beverage("지리산암반수", 2000,500);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart cart(){
        return new ShoppingCart();
    }

    @Bean(initMethod = "openShop",destroyMethod = "closeShop")
    public Owner owner(){
        return new Owner();
    }
}
