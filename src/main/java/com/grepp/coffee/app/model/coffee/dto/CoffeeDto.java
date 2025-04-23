package com.grepp.coffee.app.model.coffee.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeDto {

    private Integer coffeeId;
    private String coffeeName;
    private Integer price;
    private Integer stock;

}
