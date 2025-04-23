package com.grepp.coffee.app.model.repository.mapper;

import com.grepp.coffee.app.model.dto.CoffeeDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CoffeeMapper {

    // 모든 커피 목록 조회
    List<CoffeeDto> selectAll();

    // 커피 한 건 조회
    CoffeeDto selectById(@Param("coffeeId") Integer coffeeId);

    // 재고 증가 (입고용)
    void increaseStock(@Param("coffeeId") Integer coffeeId, @Param("quantity") Integer quantity);

    // 재고 감소 (출고용 - 주문 시 사용)
    void decreaseStock(@Param("coffeeId") Integer coffeeId, @Param("quantity") Integer quantity);

    // (선택) 커피 추가
    void insertCoffee(CoffeeDto coffeeDto);

    // (선택) 커피 삭제
    void deleteCoffee(@Param("coffeeId") Integer coffeeId);
}
