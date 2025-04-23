package com.grepp.coffee.app.model.repository.mapper;

import com.grepp.coffee.app.model.dto.CoffeeDto;
import com.grepp.coffee.app.model.dto.DetailedOrderDto;
import com.grepp.coffee.app.model.dto.OrderDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    // 주문 등록
    void insertOrder(OrderDto order);

    // 상세 주문 등록
    void insertDetailedOrder(DetailedOrderDto detailedOrder);

    // 커피 조회
    CoffeeDto selectCoffeeById(@Param("coffeeId") Integer coffeeId);

    // 커피 재고 차감
    void decreaseStock(@Param("coffeeId") Integer coffeeId, @Param("quantity") Integer quantity);

    // 주문 번호로 상세 주문 목록 조회
    List<DetailedOrderDto> selectDetailedOrderByOrderNum(@Param("orderNum") Integer orderNum);

    // 주문 번호로 주문 정보 조회
    OrderDto selectOrderByOrderNum(@Param("orderNum") Integer orderNum);

    // 이메일 기준으로 오늘 주문 조회 (하루 1건만 처리용)
    OrderDto findTodayOrderByEmailAndPostNum(@Param("email") String email, @Param("postNum") Integer postNum);
}
