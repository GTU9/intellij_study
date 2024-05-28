package com.ohgiraffers.springdatajpa.service;

import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.repository.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    private final ModelMapper modelMapper;

    public MenuService(MenuRepository menuRepository, ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    /*1. findById()*/
    public MenuDTO findMenuByMenuCode(int menuCode){

        Menu foundMenu=menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(foundMenu, MenuDTO.class);
    }

    /*2. findAll() : with no paging*/
    public List<MenuDTO> findMenuList(){
        List<Menu> menuList=menuRepository.findAll(Sort.by("menuCode").descending());

        return menuList.stream()
                .map(menu -> modelMapper.map(menu,MenuDTO.class))
                .collect(Collectors.toList());

    }

    public Page<MenuDTO> findMenuList(Pageable pageable){
        pageable= PageRequest.of(pageable.getPageNumber()<=0 ? 0 : pageable.getPageNumber()-1,
                pageable.getPageSize(),
                Sort.by("menuCode").descending());

        Page<Menu> menuList=menuRepository.findAll(pageable);

        return null;
    }
}
