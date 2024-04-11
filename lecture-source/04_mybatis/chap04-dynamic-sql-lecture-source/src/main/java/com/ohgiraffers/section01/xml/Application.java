package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.SearchCriteria;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        do{
            System.out.println("==========================MyBatis Dynamic SQL==============================");
            System.out.println("1. if test");
            System.out.println("2. choose(when, otherwise) test");
            System.out.println("3. foreach test");
            System.out.println("4. trim(where, set) test");
            System.out.println("9. 프로그램 종료");
            System.out.print("실행할 메뉴 번호를 입력하세요 : ");
            int no =sc.nextInt();


            switch (no){
                case 1:
                    infSubMenu(); break;
                case 2: chooseSubMenu();break;
                case 3: foreachSubMenu();break;
                case 4: trimSubMenu(); break;
                case 9:
                    System.out.println("프로그램을 종료합니다."); break;
            }
        }while(true);
    }

    private static void infSubMenu() {
        Scanner sc= new Scanner(System.in);
        MenuService menuService= new MenuService();

        do{
            System.out.println("==========================if Sub Menu==============================");
            System.out.println("1. 원하는 금액대에 적합한 추천 메뉴 목록 조회");
            System.out.println("2. 메뉴명 또는 카테고리명으로 검색한 메뉴 목록 조회");
            System.out.println("9. 이전 메뉴로 이동");
            System.out.print("실행할 메뉴 번호를 입력하세요 : ");
            int no=sc.nextInt();

            switch (no){
                case 1:
                    menuService.selectMenuByPrice(inputPrice()); break;
                case 2:
                    menuService.searchMenu(inputSearchCriteria()); break;
                case 9:
                    return;
            }
        }while(true);
    }

    private static int inputPrice() {
        Scanner sc=new Scanner(System.in);
        System.out.print("찾을 메뉴의 최대 금액을 입력하세요 : ");
        int price=sc.nextInt();

        return price;
    }

    private static SearchCriteria inputSearchCriteria() {
        Scanner sc=new Scanner(System.in);
        System.out.print("검색 기준을 입력하세요(category 또는 menu) : ");
        String condtion =sc.nextLine();
        System.out.print("검색어를 입력하세요 : ");
        String value = sc.nextLine();

        return new SearchCriteria (condtion, value);
    }

    private static void chooseSubMenu(){
        Scanner sc= new Scanner(System.in);
        MenuService menuService=new MenuService();

        do{
            System.out.println("==========================choose Sub Menu==============================");
            System.out.println("1. 카테고리 상위 분류별 메뉴 목록 조회");
            System.out.println("9. 이전 메뉴로 돌아가기 ");
            System.out.print("실행할 메뉴를 입력하세요 :  ");
            int no=sc.nextInt();

            switch(no){
                case 1: menuService.searchMenuBySupCategory(inputSupCategory()); break;
                case 9: return;
            }
        }while(true);

    }

    private static SearchCriteria inputSupCategory(){
        Scanner sc=new Scanner(System.in);
        System.out.print("상위 분류를 입력하세요 (식사 or 음료 or 디저트) : ");
        String value=sc.nextLine();

        return new SearchCriteria ("supCategory", value) ;
    }

    private static void foreachSubMenu(){
        Scanner sc=new Scanner(System.in);
        MenuService menuService=new MenuService();

        do{
            System.out.println("==========================choose Sub Menu==============================");
            System.out.println("1. 랜덤한 메뉴 5개 추출 조회");
            System.out.println("9. 이전 메뉴로 돌아가기 ");
            System.out.print("실행할 메뉴를 입력하세요 :  ");
            int no=sc.nextInt();

            switch(no){
                case 1: menuService.searchMenuByRandomMenuCode(createRandomMenuCodeList()); break;
                case 9: return;
            }
        }while(true);
    }

    public static List<Integer> createRandomMenuCodeList(){
        Set<Integer> set =new HashSet<>();
        while (set.size()<5){
            int temp=((int)(Math.random()*20)+1);
            set.add(temp);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        return list;
    }

    private static void trimSubMenu() {
        Scanner sc=new Scanner(System.in);
        MenuService menuService=new MenuService();
    }
}
