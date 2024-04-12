package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface SqlBuilderMapper {

    @InsertProvider(type=SqlBuilderProvider.class,method = "registMenu")
    int registMenu(MenuDTO newMenu);

    @UpdateProvider(type=SqlBuilderProvider.class,method = "modifyMenu")
    int modifyMenu(MenuDTO modifyMenu);
}
