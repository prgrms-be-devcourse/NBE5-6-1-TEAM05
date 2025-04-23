package com.grepp.coffee.service.menu;

import com.grepp.coffee.app.model.dto.CoffeeDto;
import java.util.List;

public interface MenuService {
    void addMenu(CoffeeDto coffeeDto);  // 커피 메뉴 추가
    List<CoffeeDto> getAllCoffee();
    void updateMenu(CoffeeDto coffeeDto);
    void deleteMenu(CoffeeDto coffeeDto);
}
