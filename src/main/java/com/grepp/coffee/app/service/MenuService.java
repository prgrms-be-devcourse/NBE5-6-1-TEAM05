package com.grepp.coffee.app.service;

import com.grepp.coffee.app.model.dto.CoffeeDto;
import com.grepp.coffee.app.model.repository.CoffeeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final CoffeeRepository coffeeRepository;

    /** DB에 새로운 커피 메뉴를 추가합니다. */
    @Transactional
    public boolean addMenu(CoffeeDto coffeeDto) {
        return coffeeRepository.insertCoffee(coffeeDto);
    }

    /** DB로부터 모든 커피 메뉴들을 가져옵니다. */
    public List<CoffeeDto> getAllCoffee() {
        return coffeeRepository.getAllCoffee();
    }

    /** DB로부터 특정 커피 메뉴에 대한 데이터를 가져옵니다. */
    public CoffeeDto getCoffee(CoffeeDto coffeeDto) {
        return coffeeRepository.getCoffeeById(coffeeDto.getCoffeeId());
    }

    /** DB에 저장된 커피 메뉴를 수정합니다. */
    @Transactional
    public boolean updateMenu(CoffeeDto coffeeDto) {
        return coffeeRepository.updateCoffee(coffeeDto);
    }

    /** DB에 저장된 커피메뉴를 삭제합니다. */
    @Transactional
    public boolean deleteMenu(CoffeeDto coffeeDto) {
        return coffeeRepository.deleteCoffee(coffeeDto.getCoffeeId());
    }
}
