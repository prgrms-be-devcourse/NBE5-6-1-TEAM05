package com.grepp.coffee.app.controller.web.member.payload;

import com.grepp.coffee.app.model.coffee.dto.CoffeeImgDto;
import java.util.List;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MypageRequest {

    private String coffeeName;
    private List<CoffeeImgDto> thumbnail;
    private int quantity;

}
