package com.grepp.coffee.app.model.dto;

import com.grepp.coffee.app.model.dto.code.CoffeeImgType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("CoffeeImgDto")
public class CoffeeImgDto {
    private Integer imgId;
    private Integer coffeeId;
    private CoffeeImgType type;
    private String originFileName;
    private String renameFileName;
    private String savaPath;

    public String getUrl() {
        return "/download/" + savaPath + renameFileName;
    }
}
