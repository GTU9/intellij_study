package com.ohgiraffers.springdatajpa.menu.controller;

import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private static final Logger log = LoggerFactory.getLogger(MenuController.class);
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService=menuService;
    }

    @GetMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable int menuCode, Model model) {
        MenuDTO resultMenu = menuService.findMenuByMenuCode(menuCode);

        model.addAttribute("menu", resultMenu);

        return "menu/detail";
    }

    @GetMapping("/List")
    public String findMenuList(Model model, @PageableDefault Pageable pageable) {
        /*
        List<MenuDTO> menuList = menuService.findMenuList();

        model.addAttribute("menuList", menuList);

        return "menu/list";
        */
        log.info("pageable : {}", pageable);

        Page<MenuDTO> menuList=menuService.findMenuList(pageable);

        model.addAttribute("menuList", menuList);

        return "menu/list";
    }
}
