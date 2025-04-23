package com.grepp.coffee.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("DetailedOrderDto")
public class DetailedOrderDto {

    private Integer detailNum;
    private Integer orderNum;
    private Integer coffeeId;
    private Integer quantity;

}
