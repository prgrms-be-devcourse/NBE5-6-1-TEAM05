package com.grepp.coffee.app.service.order;

import com.grepp.coffee.app.model.dto.DetailedOrderDto;

public interface OrderService {
    void processOrder(DetailedOrderDto detailedOrderDto);
    void updateOrder(DetailedOrderDto detailedOrderDto);
    void deleteOrder(DetailedOrderDto detailedOrderDto);
    DetailedOrderDto getDetailedOrderDto();
}
