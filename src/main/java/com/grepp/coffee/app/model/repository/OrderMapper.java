package com.grepp.coffee.app.model.repository;

import com.grepp.coffee.app.model.dto.CoffeeDto;
import com.grepp.coffee.app.model.dto.DetailedOrderDto;
import com.grepp.coffee.app.model.dto.OrderDto;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

    // 주문 등록
    void insertOrder(OrderDto order);

    // 상세 주문 등록
    void insertDetailedOrder(DetailedOrderDto detailedOrder);

    // 커피 재고, 가격 조회
    CoffeeDto selectCoffeeById(@Param("coffeeId") Integer coffeeId);

    // 재고 감소
    void decreaseStock(@Param("coffeeId") Integer coffeeId, @Param("quantity") Integer quantity);

    // 주문 번호로 상세 주문 목록 조회 (선택사항)
    List<DetailedOrderDto> selectDetailedOrderByOrderNum(@Param("orderNum") Integer orderNum);

    // (선택) 주문 번호로 주문 정보 조회
    OrderDto selectOrderByOrderNum(@Param("orderNum") Integer orderNum);
}
