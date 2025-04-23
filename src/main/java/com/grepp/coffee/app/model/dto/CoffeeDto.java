package com.grepp.coffee.app.model.dto;

import lombok.AllArgsConstructor;
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
