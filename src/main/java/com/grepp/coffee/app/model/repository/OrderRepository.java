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
    public boolean saveOrderWithItems(OrderDto order, List<DetailedOrderDto> orderItems) {
        int result = orderMapper.insertOrder(order);
        if (result == 0) return false;

        for (DetailedOrderDto item : orderItems) {
            item.setOrderNum(order.getOrderNum());

            int detailResult = orderMapper.insertDetailedOrder(item);
            boolean stockResult = orderMapper.decreaseStock(item.getCoffeeId(), item.getQuantity());

            if (detailResult == 0 || !stockResult) {
                return false;
            }
        }

        return true;
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

    // 이메일 기준으로 오늘 주문이 있으면 detail만 추가, 없다면 주문 생성 후 detail 추가
    public boolean saveOrderSmart(OrderDto order, List<DetailedOrderDto> orderItems) {
        OrderDto existingOrder = orderMapper.findTodayOrderByEmailAndPostNum(order.getEmail(), order.getPostNum());

        if (existingOrder == null) {
            int result = orderMapper.insertOrder(order);
            if (result == 0) return false;

            for (DetailedOrderDto item : orderItems) {
                item.setOrderNum(order.getOrderNum());
                if (orderMapper.insertDetailedOrder(item) == 0 ||
                    !orderMapper.decreaseStock(item.getCoffeeId(), item.getQuantity())) {
                    return false;
                }
            }
        } else {
            for (DetailedOrderDto item : orderItems) {
                item.setOrderNum(existingOrder.getOrderNum());
                if (orderMapper.insertDetailedOrder(item) == 0 ||
                    !orderMapper.decreaseStock(item.getCoffeeId(), item.getQuantity())) {
                    return false;
                }
            }
        }

        return true;
    }

    // 커피 가격/재고 조회
    public CoffeeDto getCoffeeInfo(int coffeeId) {
        return orderMapper.selectCoffeeById(coffeeId);
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