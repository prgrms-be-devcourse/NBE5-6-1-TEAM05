package com.grepp.coffee.app.model.dto;

import com.grepp.coffee.app.model.dto.code.CoffeeImgType;
import com.grepp.coffee.infra.util.file.FileDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@Alias("CoffeeImgDto")
public class CoffeeImgDto {
    private Integer imgId;
    private Integer coffeeId;
    private CoffeeImgType type;
    private String originFileName;
    private String renameFileName;
    private String savePath;

    public CoffeeImgDto(Integer coffeeId, CoffeeImgType type, FileDto fileDto) {
        this.coffeeId = coffeeId;
        this.type = type;
        this.originFileName = fileDto.originFileName();
        this.renameFileName = fileDto.renameFileName();
        this.savePath = fileDto.savePath();
    }

    public String getUrl() {
        return "/download/" + savePath + renameFileName;
    }
}
