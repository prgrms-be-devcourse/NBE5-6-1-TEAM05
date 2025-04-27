package com.grepp.coffee.app.model.coffee.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@Alias("CoffeeDto")
public class CoffeeDto {

    private Integer coffeeId;
    private String coffeeName;
    private List<CoffeeImgDto> images;
    private Integer price;
    private Integer stock;

    public CoffeeDto(Integer coffeeId, String coffeeName, Integer price, Integer stock) {
        this.coffeeId = coffeeId;
        this.coffeeName = coffeeName;
        this.price = price;
        this.stock = stock;
    }
}
