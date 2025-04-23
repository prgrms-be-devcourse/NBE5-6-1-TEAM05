package com.grepp.coffee.app.service.menu;

import com.grepp.coffee.app.model.dto.CoffeeDto;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// TODO : 매서드 수정

@Service
public class MenuServiceImpl implements MenuService {

    // 커피 추가시 ID는 DB에서 자동으로 +1씩 추가됨
    // DB에 새로운 커피 메뉴 추가
    @Override
    @Transactional
    public void addMenu(CoffeeDto coffeeDto) {
        // 커피 이름, 가격, 재고가 전달 되야함.
    }

    // DB에 저장된 커피 메뉴들을 가져옴
    @Override
    public List<CoffeeDto> getAllCoffee() {
        // 커피의 ID는 필요하지 않음
        return null;
    }

    // DB에 저장된 커피 메뉴를 수정함
    @Override
    @Transactional
    public void updateMenu(CoffeeDto coffeeDto) {
        // 커피의 이름, 가격, 재고 중 일부를 수정함
    }

    // DB에 저장된 커피메뉴를 삭제함
    @Override
    @Transactional
    public void deleteMenu(CoffeeDto coffeeDto) {
        // 커피를 삭제함
    }
}
