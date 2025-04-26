package com.grepp.coffee.app.controller.web.admin.payload;

import com.grepp.coffee.app.model.coffee.dto.CoffeeDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CoffeeRegistRequest {
    private List<MultipartFile> thumbnail;
    private Integer coffeeId;
    @NotBlank
    private String coffeeName;
    @Min(1)
    private Integer price;
    @Min(1)
    private Integer stock;

    public CoffeeDto toDto(){
        CoffeeDto coffee = new CoffeeDto();

        coffee.setCoffeeId(coffeeId);
        coffee.setCoffeeName(coffeeName);
        coffee.setPrice(price);
        coffee.setStock(stock);

        return coffee;
    }
}
