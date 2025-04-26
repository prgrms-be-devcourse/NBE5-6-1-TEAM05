package com.grepp.coffee.app.model.order;


import com.grepp.coffee.app.model.order.dto.DetailedOrderDto;
import com.grepp.coffee.app.model.order.dto.MyPageOrderDto;
import com.grepp.coffee.app.model.order.dto.OrderDto;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    /**
     * 고객이 주문을 확정 했을 때 해당 주문을 DB에 반영합니다.
     * 만약 고객이 같은 주소로 주문했을 경우, 배송 마감 시간을 기준으로 기존의 주문 정보를 업데이트합니다.
     * */
    @Transactional
    public boolean processOrder(OrderDto orderDto, List<DetailedOrderDto> detailedOrderLists) {
        OrderDto existingOrder = orderRepository.findTodayOrder(orderDto.getEmail(),
            orderDto.getPostNum());

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime todayCutoff = now.toLocalDate().atTime(14, 0);
        LocalDateTime yesterdayCutoff = todayCutoff.minusDays(1);

        // 동일 고객의 같은 주소로의 주문 건이 있을 때
        if(existingOrder != null){
            LocalDateTime orderTime = existingOrder.getOrderTime();
            // 주문시간이 오늘 2시 전일 경우
            if(orderTime.isAfter(yesterdayCutoff) && orderTime.isBefore(todayCutoff)){
                for (DetailedOrderDto item : detailedOrderLists) {
                    item.setOrderNum(existingOrder.getOrderNum());
                    if (!orderRepository.insertDetailAndDecreaseStock(item)) {
                        return false;
                    }
                }
                return true;
            }
        }
        // 주문 내역이 없거나 2시 이후일 경우
        boolean created = orderRepository.insertOrder(orderDto);
        if(!created){
            return false;
        }

        for(DetailedOrderDto item : detailedOrderLists){
            item.setOrderNum(orderDto.getOrderNum());
            if (!orderRepository.insertDetailAndDecreaseStock(item)) {
                return false;
            }
        }
        return true;
    }

    /** 고객이 주문을 취소한 경우 해당 취소 내역을 DB에 반영합니다. */
    @Transactional
    public boolean deleteOrder(OrderDto orderDto) {
        return orderRepository.deleteOrder(orderDto.getEmail(), orderDto.getPostNum());
    }

    /** 고객이 주문정보 열람시 고객의 모든 주문 정보를 가져옵니다. */
    @Transactional
    public List<MyPageOrderDto> getDetailedOrderList(String email) {
        return orderRepository.getDetailedOrdersByEmail(email);
    }
}
