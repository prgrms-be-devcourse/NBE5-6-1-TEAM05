package com.grepp.coffee.app.controller.web.admin.payload;

import lombok.Data;

@Data
public class DetailOrderRequest {

    String coffeeName;
    Integer coffeeId;
    Integer quantity;

}
