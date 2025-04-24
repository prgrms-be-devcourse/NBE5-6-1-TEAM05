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
    int insertOrder(OrderDto order);

    // 상세 주문 등록
    int insertDetailedOrder(DetailedOrderDto detailedOrder);

    // 커피 조회
    CoffeeDto selectCoffeeById(@Param("coffeeId") Integer coffeeId);

    // 커피 재고 차감
    boolean decreaseStock(@Param("coffeeId") Integer coffeeId, @Param("quantity") Integer quantity);

    // 이메일, 주소번호 기준으로 오늘 주문 조회 (하루 1건만 처리용)
    OrderDto findTodayOrderByEmailAndPostNum(@Param("email") String email, @Param("postNum") Integer postNum);

    // 이메일, 주소번호 기준으로 상세 주문 목록 조회
    List<DetailedOrderDto> findDetailedOrderByEmailAndPostNum(@Param("email") String email, @Param("postNum") Integer postNum);

    // 이메일, 주소번호 기준으로 주문 삭제
    int deleteOrderByEmailAndPostNum(@Param("email") String email, @Param("postNum") Integer postNum);

    // 이메일, 주소번호 기준으로 상세 주문 삭제
    int deleteDetailedOrdersByEmailAndPostNum(@Param("email") String email, @Param("postNum") Integer postNum);
}
