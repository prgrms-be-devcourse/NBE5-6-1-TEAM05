package com.grepp.coffee.app.model.coffee.mapper;

import com.grepp.coffee.app.model.coffee.dto.CoffeeDto;
import com.grepp.coffee.app.model.coffee.dto.CoffeeImgDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CoffeeMapper {

    // 커피 한 건 조회
    CoffeeDto selectByCoffeeId(@Param("coffeeId") Integer coffeeId);

    // 모든 커피 목록 조회
    List<CoffeeDto> selectAllCoffee();

    // 커피 등록
    int insertCoffee(CoffeeDto coffeeDto);

    // 커피 이미지 등록
    int insertCoffeeImg(CoffeeImgDto coffeeImgDto);

    // 커피 수정
    int updateCoffee(CoffeeDto coffeeDto);

    // 커피 이미지 수정
    int updateCoffeeImg(CoffeeImgDto coffeeImgDto);

    // 커피 삭제
    int deleteCoffee(@Param("coffeeId") Integer coffeeId);

    // 커피 이미지 삭제
    int deleteCoffeeImg(@Param("imgId") Integer imgId);

    // 커피 재고 증가
    int increaseStock(@Param("coffeeId") Integer coffeeId, @Param("quantity") Integer quantity);

    // 커피 재고 감소
    int decreaseStock(@Param("coffeeId") Integer coffeeId, @Param("quantity") Integer quantity);
}
