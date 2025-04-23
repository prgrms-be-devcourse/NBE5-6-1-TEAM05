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
public class OrderServiceImpl {

    private final OrderRepository orderRepository;

    // 주문을 확정했을 때, 상세 주문 DB에 데이터 추가 또는 업데이트
    @Transactional
    public void processOrder(OrderDto orderDto, List<DetailedOrderDto> detailedOrderLists) {
        // 동일한 이메일, 주소(우편번호)로 들어온 주문인지 검증
        orderRepository.saveOrderSmart(orderDto, detailedOrderLists);
    }

    // 주문을 취소 했을 때 처리
    @Transactional
    public void deleteOrder(OrderDto orderDto) {
        //TODO: orderDto를 넘겨서 존재하는 주문 목록을 삭제
    }

    // 상세 주문 정보를 가져온다.
    @Transactional
    public DetailedOrderDto getDetailedOrderDto(OrderDto orderDto) {

        return null;
    }
}
