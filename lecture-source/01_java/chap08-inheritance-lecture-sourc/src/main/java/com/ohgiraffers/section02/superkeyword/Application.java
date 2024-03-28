package com.ohgiraffers.section02.superkeyword;

public class Application {
    public static void main(String[] args) {
        /*Product 기본 생성자로 인스턴스 생성 후 정보 출력*/
        Product product1=new Product();
        System.out.println(product1.getInfomation());

        /*Product의 모든 필드를 초기화하는 생성자로 인스턴스 생성 후 정보 출력*/
        Product product2=new Product("S-0134","삼성","갤럭시Z폴드2",2398000, new java.util.Date());
        System.out.println(product2.getInfomation());

        /*Computer 기본생성자로 인스턴스 생성 후 정보 출력*/
        Computer computer1=new Computer();
        System.out.println(computer1.getInformation());

        /*Computer의 모든 필드를 초기화하는 생성자로 인스턴스 생성 후 정보 출력*/
        Computer computer2=new Computer("퀄컴 스냅드래곤", 512,12,"안드로이드");
        System.out.println(computer2.getInformation());

        /*Computer 부모필드도 함께 초기화 하는 생성자로 인스턴스 생성 후 정보 출력*/
        Computer computer3=new Computer("S-0134","삼성","갤럭시Z폴드2",2398000, new java.util.Date(),
                "퀄컴 스냅드래곤", 512,12,"안드로이드");
        System.out.println(computer3.getInformation());
    }
}
