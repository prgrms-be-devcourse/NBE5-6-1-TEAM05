package com.grepp.coffee.app.controller.api.order;

import com.grepp.coffee.app.controller.session.CoffeeSessionData;
import com.grepp.coffee.app.model.dto.CoffeeDto;
import com.grepp.coffee.app.service.MenuService;
import com.grepp.coffee.infra.response.ApiResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api")
public class OrderApiController {

    // TODO 잘 굴러가는지 확인 일단 데이터 불러오는 거 다 빼고 Js에서 확인해보기
    
    private final MenuService menuService;

    @PutMapping("add/{id}")
    public ResponseEntity<ApiResponse<CoffeeSessionData>> addCount(
        @PathVariable
        Integer id, HttpSession session) {
        
        // session에 저장된 값이 없으면 새로 생성
        if(session.getAttribute("coffee"+id) == null) {
            // 생성할 데이터 가져오기
            CoffeeDto coffeeDto = menuService.getCoffee(new CoffeeDto(id,null,null,null));
            
            // 세션에 넣을 데이터 가공
            CoffeeSessionData coffeeSessionData = new CoffeeSessionData();
            coffeeSessionData.setId(coffeeDto.getCoffeeId());
            coffeeSessionData.setName(coffeeDto.getCoffeeName());
            coffeeSessionData.setCoffeeCount(1);
            
            // 세션에 추가
            String key = "coffee"+id;
            session.setAttribute(key, coffeeSessionData);
        }else{
            CoffeeSessionData count = (CoffeeSessionData) session.getAttribute("coffee"+id);
            count.setCoffeeCount(count.getCoffeeCount()+1);
            String key = "coffee"+id;
            session.setAttribute(key, count);
        }

        CoffeeSessionData payload = (CoffeeSessionData) session.getAttribute("coffee"+id);

        return ResponseEntity.ok(ApiResponse.success(payload));
    }

    @PutMapping("/sub/{id}")
    public ResponseEntity<ApiResponse<CoffeeSessionData>> subCount(
        @PathVariable
        Integer id, HttpSession session) {

        CoffeeSessionData count = (CoffeeSessionData) session.getAttribute("coffee"+id);
        count.setCoffeeCount(count.getCoffeeCount()-1);

        CoffeeSessionData payload = (CoffeeSessionData) session.getAttribute("coffee"+id);

        if(count.getCoffeeCount()==0) {
            session.removeAttribute("coffee"+id);
            return ResponseEntity.ok(ApiResponse.noContent());
        }

        return ResponseEntity.ok(ApiResponse.success(payload));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<CoffeeSessionData>> deleteCount(
        @PathVariable
        Integer id, HttpSession session){
        
        // 세션에서 삭제하기 구현
        session.removeAttribute("coffee"+id);
        
        return ResponseEntity.ok(ApiResponse.noContent());
    }

}
