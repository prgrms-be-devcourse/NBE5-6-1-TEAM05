package com.grepp.coffee.app.model.coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("CoffeeDto")
public class CoffeeDto {

    private Integer coffeeId;
    private String coffeeName;
    private Integer price;
    private Integer stock;

}
