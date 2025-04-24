package com.grepp.coffee.app.service;


import com.grepp.coffee.app.model.dto.DetailedOrderDto;
import com.grepp.coffee.app.model.dto.OrderDto;
import com.grepp.coffee.app.model.repository.OrderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    /** 고객이 주문을 확정 했을 때 해당 주문을 DB에 반영합니다. */
    @Transactional
    public boolean processOrder(OrderDto orderDto, List<DetailedOrderDto> detailedOrderLists) {
        return orderRepository.saveOrderSmart(orderDto, detailedOrderLists);
    }

    /** 고객이 주문을 취소한 경우 해당 취소 내역을 DB에 반영합니다. */
    @Transactional
    public boolean deleteOrder(OrderDto orderDto) {
        return orderRepository.deleteOrder(orderDto.getEmail(), orderDto.getPostNum());
    }

    /** 고객이 주문정보 열람시 고객의 주문 정보를 가져옵니다. */
    @Transactional
    public List<DetailedOrderDto> getDetailedOrderList(OrderDto orderDto) {
        return orderRepository.getDetailedOrdersByEmailAndPostNum(orderDto.getEmail(), orderDto.getPostNum());
    }
}
