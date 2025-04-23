package com.grepp.coffee.app.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetailedOrderDto {

    private Integer detailNum;
    private Integer orderNum;
    private Integer coffeeId;
    private Integer quantity;

}
