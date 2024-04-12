package com.ohgiraffers.section01.problem;

public class MenuAndCategory {

    private int menu_code;
    private String menu_name;
    private int menu_price;
    private Category category;
    private String orderableStatus;

    public MenuAndCategory() {
    }

    public MenuAndCategory(int menu_code, String menu_name, int menu_price, Category category, String orderableStatus) {
        this.menu_code = menu_code;
        this.menu_name = menu_name;
        this.menu_price = menu_price;
        this.category = category;
        this.orderableStatus = orderableStatus;
    }

    public int getMenu_code() {
        return menu_code;
    }

    public void setMenu_code(int menu_code) {
        this.menu_code = menu_code;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public int getMenu_price() {
        return menu_price;
    }

    public void setMenu_price(int menu_price) {
        this.menu_price = menu_price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuAndCategory{" +
                "menu_code=" + menu_code +
                ", menu_name='" + menu_name + '\'' +
                ", menu_price=" + menu_price +
                ", category=" + category +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
