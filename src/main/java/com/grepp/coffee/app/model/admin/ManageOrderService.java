package com.grepp.coffee.app.model.admin;

import com.grepp.coffee.app.model.dto.DetailedOrderDto;
import com.grepp.coffee.app.model.dto.OrderDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ManageOrderService {

    private final ManageOrderRepository manageOrderRepository;

    /** 전체 주문 목록을 반환합니다. */
    public List<OrderDto> getOrders(){
        return manageOrderRepository.selectAllOrders();
    }

    /** 상세 주문 내역을 반환합니다. */
    public List<DetailedOrderDto> getDetailedOrders(Integer orderId){
        return manageOrderRepository.selectAllDetailedOrdersById(orderId);
    }


    /** 주문을 취소합니다. */
    @Transactional
    public boolean cancelOrder(Integer orderId){
        return manageOrderRepository.deleteDetailedOrder(orderId) &&
            manageOrderRepository.deleteOrder(orderId);
    }

    /** 주문의 배송상태를 완료로 업데이트 합니다. */
    @Transactional
    public boolean confirmOrder(Integer orderId){
        return manageOrderRepository.updateDelivery(orderId);
    }
}
