package com.grepp.coffee.app.model.dto;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDto {

    private Integer orderNum;
    private String email;
    private String address;
    private Integer postNum;
    private LocalDateTime orderTime;
}
