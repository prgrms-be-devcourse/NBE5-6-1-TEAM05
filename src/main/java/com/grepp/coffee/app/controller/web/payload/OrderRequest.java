package com.grepp.coffee.app.controller.web.payload;

import com.grepp.coffee.app.model.dto.OrderDto;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class OrderRequest {

    // 커피 종류와 수량은 session에 저장된 값을 사용
    // 고객 email과 주소, 우편번호만 받기

    @Email
    private String email;
    private String address;
    private Integer postNum;

    public OrderDto toOrderDto() {
        OrderDto orderDto = new OrderDto();
        orderDto.setEmail(email);
        orderDto.setAddress(address);
        orderDto.setPostNum(postNum);
        return orderDto;
    }

}
