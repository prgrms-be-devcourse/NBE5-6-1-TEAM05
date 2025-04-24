package com.grepp.coffee.app.model.repository;

import com.grepp.coffee.app.model.dto.DetailedOrderDto;
import com.grepp.coffee.app.model.dto.OrderDto;
import com.grepp.coffee.app.model.repository.mapper.OrderMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    private final OrderMapper orderMapper;

    @Autowired
    public OrderRepository(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    /** 2시 이전에 같은 주소로의 주문이 있는지 확인합니다. */
    public OrderDto findTodayOrder(String email, int postNum){
        return orderMapper.findTodayOrderByEmailAndPostNum(email, postNum);
    }

    /** 새로운 주문을 DB에 반영합니다. */
    public boolean insertOrder(OrderDto order) {
        return orderMapper.insertOrder(order) > 0;
    }

    /** 상세 주문 내역을 반영하고 재고를 차감합니다. */
    public boolean insertDetailAndDecreaseStock(DetailedOrderDto detailedOrderDto) {
        return orderMapper.insertDetailedOrder(detailedOrderDto) > 0 &&
            orderMapper.decreaseStock(
                detailedOrderDto.getCoffeeId(),
                detailedOrderDto.getQuantity()
            );
    }

    // 주문 삭제
    public boolean deleteOrder(String email, int postNum) {
        int detailDeleted = orderMapper.deleteDetailedOrdersByEmailAndPostNum(email, postNum);
        int orderDeleted = orderMapper.deleteOrderByEmailAndPostNum(email, postNum);
        return detailDeleted > 0 && orderDeleted > 0;
    }

    // 상세 주문 조회
    public List<DetailedOrderDto> getDetailedOrdersByEmailAndPostNum(String email, int postNum) {
        return orderMapper.findDetailedOrderByEmailAndPostNum(email, postNum);
    }
}