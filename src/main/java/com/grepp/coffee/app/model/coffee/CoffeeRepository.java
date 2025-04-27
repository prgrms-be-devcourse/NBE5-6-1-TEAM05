package com.grepp.coffee.app.model.coffee;

import com.grepp.coffee.app.model.coffee.dto.CoffeeDto;
import com.grepp.coffee.app.model.coffee.dto.CoffeeImgDto;
import com.grepp.coffee.app.model.coffee.mapper.CoffeeMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
* TODO
*  - 커피 메뉴 수정시 CoffeeDto 와 CoffeeImgDto 를 받아 함께 수정되도록 매서드 수정
*  - 커피 메뉴 불러오기시 CoffeeImg 도 반환 되어야 합니다. (전체, 하나 검색 모두)
*  - 커피 삭제시 CoffeeDto 를 받아옵니다. Id 를 통해 CoffeeImg 도 삭제되어야 합니다.
* */

@Repository
public class CoffeeRepository {

    private final CoffeeMapper coffeeMapper;

    @Autowired
    public CoffeeRepository(CoffeeMapper coffeeMapper) {
        this.coffeeMapper = coffeeMapper;
    }

    // TODO : 커피 이미지도 가져오도록 해주세요. (완료)
    // 커피 한 건 조회
    public CoffeeDto selectByCoffeeId(int coffeeId) {
        return coffeeMapper.selectByCoffeeId(coffeeId);
    }

    // TODO : 커피 이미지도 가져오도록 해주세요. (완료)
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

    // TODO : 커피 이미지 업데이트 매서드 (완료)
    public boolean updateCoffeeImg(CoffeeImgDto dto) {
        return coffeeMapper.updateCoffeeImg(dto) > 0;
    }

    // 커피 삭제
    public boolean deleteCoffee(int coffeeId) {
        return coffeeMapper.deleteCoffee(coffeeId) > 0;
    }

    // TODO : 커피 이미지 삭제 매서드 (완료)
    public boolean deleteCoffeeImg(int imgId){return coffeeMapper.deleteCoffeeImg(imgId) > 0;}

    // 재고 증가
    public boolean increaseStock(int coffeeId, int quantity) {
        return coffeeMapper.increaseStock(coffeeId, quantity) > 0;
    }

    // 재고 감소
    public boolean decreaseStock(int coffeeId, int quantity) {
        return coffeeMapper.decreaseStock(coffeeId, quantity) > 0;
    }
}
