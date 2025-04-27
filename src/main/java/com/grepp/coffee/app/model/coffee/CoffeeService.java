package com.grepp.coffee.app.model.coffee;

import com.grepp.coffee.app.model.coffee.code.CoffeeImgType;
import com.grepp.coffee.app.model.coffee.dto.CoffeeDto;
import com.grepp.coffee.app.model.coffee.dto.CoffeeImgDto;
import com.grepp.coffee.infra.error.exceptions.CommonException;
import com.grepp.coffee.infra.response.ResponseCode;
import com.grepp.coffee.infra.util.file.FileDto;
import com.grepp.coffee.infra.util.file.FileUtil;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;
    private final FileUtil fileUtil;

    /** DB에 새로운 커피 메뉴를 추가합니다. */
    @Transactional
    public boolean addMenu(List<MultipartFile> thumbnail, CoffeeDto coffeeDto) {
        try {
            List<FileDto> fileDtos = fileUtil.upload(thumbnail, "coffee");
            if(fileDtos.isEmpty()) return false;
            coffeeRepository.insertCoffee(coffeeDto);

            CoffeeImgDto coffeeImg = new CoffeeImgDto(coffeeDto.getCoffeeId(), CoffeeImgType.THUMBNAIL, fileDtos.getFirst());
            coffeeRepository.insertCoffeeImg(coffeeImg);
        } catch (IOException e) {
            throw new CommonException(ResponseCode.INTERNAL_SERVER_ERROR, e);
        }
        return true;
    }

    // test
    @Transactional
    public boolean addMenu(CoffeeDto coffeeDto) {
        return coffeeRepository.insertCoffee(coffeeDto);
    }

    /** DB로부터 모든 커피 메뉴들을 가져옵니다. */
    public List<CoffeeDto> getAllCoffee() {
        return coffeeRepository.selectAllCoffee();
    }

    /** DB로부터 특정 커피 메뉴에 대한 데이터를 가져옵니다. */
    public CoffeeDto getCoffee(CoffeeDto coffeeDto) {
        return coffeeRepository.selectByCoffeeId(coffeeDto.getCoffeeId());
    }

    /** DB에 저장된 커피 메뉴를 수정합니다. */
    @Transactional
    public boolean updateMenu(List<MultipartFile> thumbnail, CoffeeDto coffeeDto) {
        try {
            List<FileDto> fileDtos = fileUtil.upload(thumbnail, "coffee");
            if(!fileDtos.isEmpty()) {
                CoffeeImgDto coffeeImg = new CoffeeImgDto(coffeeDto.getCoffeeId(), CoffeeImgType.THUMBNAIL, fileDtos.getFirst());
                coffeeRepository.updateCoffeeImg(coffeeImg);
            }
            coffeeRepository.updateCoffee(coffeeDto);
            return true;
        } catch (IOException e) {
            throw new CommonException(ResponseCode.INTERNAL_SERVER_ERROR, e);
        }
    }

    // test
    @Transactional
    public boolean updateMenu(CoffeeDto coffeeDto) {
        return coffeeRepository.updateCoffee(coffeeDto);
    }

    /** DB에 저장된 커피메뉴를 삭제합니다. */
    @Transactional
    public boolean deleteMenu(CoffeeDto coffeeDto) {
        return coffeeRepository.deleteCoffeeImg(coffeeDto.getCoffeeId()) &&
            coffeeRepository.deleteCoffee(coffeeDto.getCoffeeId());
    }
}
