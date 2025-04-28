package com.grepp.coffee.app.model.order.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyPageOrderDto {
    private Integer orderId;
    private String address;
    private Integer postNum;
    private LocalDateTime orderTime;
    private List<DetailedOrderDto> detailedOrders;
}
