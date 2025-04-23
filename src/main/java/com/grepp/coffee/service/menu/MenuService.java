package com.grepp.coffee.service.menu;

import com.grepp.coffee.app.model.coffee.dto.CoffeeDto;

public interface MenuService {
    void addMenu(CoffeeDto coffeeDto);  // 커피 메뉴 추가
    CoffeeDto getCoffee();
    void updateMenu(CoffeeDto coffeeDto);
    void deleteMenu(CoffeeDto coffeeDto);
}
