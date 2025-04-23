package com.grepp.coffee.app.model.repository;

import com.grepp.coffee.app.model.dto.CoffeeDto;
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

    // 주문 + 상세 주문 + 재고 차감까지 일괄 처리
    public void saveOrderWithItems(OrderDto order, List<DetailedOrderDto> orderItems) {
        // 주문 저장 (orderNum 생성됨)
        orderMapper.insertOrder(order);

        // 상세 주문 저장 및 재고 차감
        for (DetailedOrderDto item : orderItems) {
            item.setOrderNum(order.getOrderNum());
            orderMapper.insertDetailedOrder(item);
            orderMapper.decreaseStock(item.getCoffeeId(), item.getQuantity());
        }
    }

    // 커피 가격/재고 조회
    public CoffeeDto getCoffeeInfo(int coffeeId) {
        return orderMapper.selectCoffeeById(coffeeId);
    }

    // 주문 단건 조회
    public OrderDto getOrderByOrderNum(int orderNum) {
        return orderMapper.selectOrderByOrderNum(orderNum);
    }

    // 주문 상세 목록 조회
    public List<DetailedOrderDto> getOrderDetailsByOrderNum(int orderNum) {
        return orderMapper.selectDetailedOrderByOrderNum(orderNum);
    }
}