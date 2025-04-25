package com.grepp.coffee.app.model.repository;

import com.grepp.coffee.app.model.dto.CoffeeDto;
import com.grepp.coffee.app.model.dto.CoffeeImgDto;
import com.grepp.coffee.app.model.repository.mapper.CoffeeMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CoffeeRepository {

    private final CoffeeMapper coffeeMapper;

    @Autowired
    public CoffeeRepository(CoffeeMapper coffeeMapper) {
        this.coffeeMapper = coffeeMapper;
    }

    // 커피 한 건 조회
    public CoffeeDto selectByCoffeeId(int coffeeId) {
        return coffeeMapper.selectByCoffeeId(coffeeId);
    }

    // 모든 커피 목록 조회
    public List<CoffeeDto> selectAllCoffee() {
        return coffeeMapper.selectAllCoffee();
    }

    // 커피 추가
    public boolean insertCoffee(CoffeeDto dto) {
        return coffeeMapper.insertCoffee(dto) > 0;
    }

    // 커피 이미지 추가
    public boolean insertCoffeeImg(CoffeeImgDto dto) {
        return coffeeMapper.insertCoffeeImg(dto) > 0;
    }

    // 커피 수정
    public boolean updateCoffee(CoffeeDto dto) {
        return coffeeMapper.updateCoffee(dto) > 0;
    }

    // 커피 삭제
    public boolean deleteCoffee(int coffeeId) {
        return coffeeMapper.deleteCoffee(coffeeId) > 0;
    }

    // 재고 증가
    public boolean increaseStock(int coffeeId, int quantity) {
        return coffeeMapper.increaseStock(coffeeId, quantity) > 0;
    }

    // 재고 감소
    public boolean decreaseStock(int coffeeId, int quantity) {
        return coffeeMapper.decreaseStock(coffeeId, quantity) > 0;
    }
}
