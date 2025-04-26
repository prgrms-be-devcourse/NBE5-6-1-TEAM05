package com.grepp.coffee.app.controller.web.order.payload;

import com.grepp.coffee.app.model.order.dto.OrderDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrderRequest {

    // 커피 종류와 수량은 session에 저장된 값을 사용
    // 고객 email과 주소, 우편번호만 받기

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String address;
    @Min(10000)
    @Max(99999)
    private Integer postNum;

    public OrderDto toOrderDto() {
        OrderDto orderDto = new OrderDto();
        orderDto.setEmail(email);
        orderDto.setAddress(address);
        orderDto.setPostNum(postNum);
        return orderDto;
    }

}
