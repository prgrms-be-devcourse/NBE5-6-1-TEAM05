package com.grepp.coffee.app.model.order.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("OrderDto")
public class OrderDto {

    private Integer orderNum;
    private String email;
    private String address;
    private Integer postNum;
    private LocalDateTime orderTime;
    private Boolean isDelivered;
}
