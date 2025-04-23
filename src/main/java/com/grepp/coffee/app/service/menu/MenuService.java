package com.grepp.coffee.app.service.menu;

import com.grepp.coffee.app.model.dto.CoffeeDto;
import java.util.List;

//TODO : 함수 리턴값 및 파라메터 수정
public interface MenuService {
    void addMenu(CoffeeDto coffeeDto);
    List<CoffeeDto> getAllCoffee();
    void updateMenu(CoffeeDto coffeeDto);
    void deleteMenu(CoffeeDto coffeeDto);
}
