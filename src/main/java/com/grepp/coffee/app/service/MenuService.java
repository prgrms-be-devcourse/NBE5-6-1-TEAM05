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

    // DB로 새로운 커피 메뉴의 추가요청을 보냅니다.
    @Transactional
    public boolean addMenu(CoffeeDto coffeeDto) {
        // 커피 이름, 가격, 재고가 전달 되야함.
        return coffeeRepository.insertCoffee(coffeeDto);
    }

    // DB에 존재하는 모든 커피 메뉴들을 가져옵니다.
    public List<CoffeeDto> getAllCoffee() {
        return coffeeRepository.getAllCoffee();
    }

    // DB로부터 특정 커피에 대한 데이터를 가져옵니다.
    public CoffeeDto getCoffee(CoffeeDto coffeeDto) {
        return coffeeRepository.getCoffeeById(coffeeDto.getCoffeeId());
    }

    // DB에 저장된 커피 메뉴를 수정합니다.
    @Transactional
    public boolean updateMenu(CoffeeDto coffeeDto) {
        return coffeeRepository.updateCoffee(coffeeDto);
    }

    // DB에 저장된 커피메뉴를 삭제합니다.
    @Transactional
    public boolean deleteMenu(CoffeeDto coffeeDto) {
        return coffeeRepository.deleteCoffee(coffeeDto.getCoffeeId());
    }
}
