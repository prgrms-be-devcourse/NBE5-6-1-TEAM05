package com.grepp.coffee.app.model.coffee;

import com.grepp.coffee.app.model.coffee.dto.CoffeeDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    /** DB에 새로운 커피 메뉴를 추가합니다. */
    @Transactional
    public boolean addMenu(CoffeeDto coffeeDto) {
        return coffeeRepository.insertCoffee(coffeeDto);
    }

    //TODO : 커피에 해당하는 이미지 가져오는 매서드 사용하여 수정
    /** DB로부터 모든 커피 메뉴들을 가져옵니다. */
    public List<CoffeeDto> getAllCoffee() {
        return coffeeRepository.selectAllCoffee();
    }

    //TODO : 커피에 해당하는 이미지 가져오는 매서드 사용하여 수정
    /** DB로부터 특정 커피 메뉴에 대한 데이터를 가져옵니다. */
    public CoffeeDto getCoffee(CoffeeDto coffeeDto) {
        return coffeeRepository.selectByCoffeeId(coffeeDto.getCoffeeId());
    }

    //TODO : 이미지 수정에 사용할 매서드 사용하여 수정
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
