package com.grepp.coffee.app.model.coffee.dto;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoffeeDto {

    private Integer coffeeId;
    private Integer price;
    private Integer stock;

}
