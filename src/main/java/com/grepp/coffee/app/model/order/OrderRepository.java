package com.grepp.coffee.app.model.order;

import com.grepp.coffee.app.model.order.dto.DetailedOrderDto;
import com.grepp.coffee.app.model.order.dto.MyPageOrderDto;
import com.grepp.coffee.app.model.order.dto.OrderDto;
import com.grepp.coffee.app.model.order.mapper.OrderMapper;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    public boolean updateAllOrdersToDelivered() {
        int updateRows = orderMapper.updateAllOrdersToDelivered();
        return updateRows > 0;
    }

    // 주문 삭제
    public boolean deleteOrder(String email, int postNum) {
        int detailDeleted = orderMapper.deleteDetailedOrdersByEmailAndPostNum(email, postNum);
        int orderDeleted = orderMapper.deleteOrderByEmailAndPostNum(email, postNum);
        return detailDeleted > 0 && orderDeleted > 0;
    }

    // 배송 완료된 주문 일괄 삭제
    @Transactional
    public boolean deleteOrdersAndDetailsByIsDelivered() {
        int detailDeleted = orderMapper.deleteDetailedOrdersByIsDelivered(Boolean.TRUE);
        int orderDeleted = orderMapper.deleteOrdersByIsDelivered(Boolean.TRUE);
        return detailDeleted > 0 && orderDeleted > 0;
    }

    // 상세 주문 조회
    public List<DetailedOrderDto> getDetailedOrdersByEmailAndPostNum(String email, int postNum) {
        return orderMapper.findDetailedOrderByEmailAndPostNum(email, postNum);
    }

    // 고객의 주문내역 조회
    public List<MyPageOrderDto> getDetailedOrdersByEmail(String email) {
        return orderMapper.selectMyPageOrdersByEmail(email);
    }

    // 오늘의 주문 수 조회
    public int getTodayOrderCount(LocalDateTime today) {
        return orderMapper.countOrdersByOrderTime(today);
    }

    public int getDeliveredOrderCount() {
        return orderMapper.countDeliveredOrder();
    }

    public int getUndeliveredOrderCount() {
        return orderMapper.countUndeliveredOrder();
    }

}