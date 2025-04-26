package com.grepp.coffee.app.model.admin;

import com.grepp.coffee.app.model.dto.DetailedOrderDto;
import com.grepp.coffee.app.model.dto.OrderDto;
import com.grepp.coffee.app.model.repository.mapper.CoffeeMapper;
import com.grepp.coffee.app.model.repository.mapper.DetailedOrderMapper;
import com.grepp.coffee.app.model.repository.mapper.OrderMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminService {

    private final OrderMapper orderMapper;
    private final CoffeeMapper coffeeMapper;
    private final DetailedOrderMapper detailedOrderMapper;

    /** 전체 주문 목록을 반환합니다. */
    public List<OrderDto> getOrders(){
        return null;
    }

    /** 상세 주문 내역을 반환합니다. */
    public List<DetailedOrderDto> getDetailedOrders(String orderId){return null;}

    /** 주문을 취소합니다. */
    public boolean cancelOrder(String orderId){return false;}

    /** 주문의 배송상태를 완료로 업데이트 합니다. */
    public boolean confirmOrder(String orderId){return false;}
}
