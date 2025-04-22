package com.grepp.coffee.app.model.detailedorder.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetailedOrderDto {

    private Integer id;
    private Integer orderNum;
    private Integer coffeeId;
    private Integer quantity;

}
