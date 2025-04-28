package com.grepp.coffee.app.controller.web.member.payload;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class UpdateAddressRequest {

    private String address;
    @Min(10000)
    @Max(99999)
    private int postNum;
}
