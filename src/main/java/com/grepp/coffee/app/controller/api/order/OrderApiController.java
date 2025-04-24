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
        
        CoffeeDto coffeeDto = menuService.getCoffee(new CoffeeDto(id,null,null,null));

        // session에 저장된 값이 없으면 새로 생성
        if(session.getAttribute("coffee"+id) == null) {
            String key = "coffee"+id;
            session.setAttribute(key, coffeeDto);
        }else{
            CoffeeSessionData count = (CoffeeSessionData) session.getAttribute("coffee"+id);
            count.setCoffeeCount(count.getCoffeeCount()+1);
            String key = "coffee"+id;
            session.setAttribute(key, count);
        }

        CoffeeSessionData payload = (CoffeeSessionData) session.getAttribute("coffee"+id);

        return ResponseEntity.ok(ApiResponse.success(payload));
    }

    @PutMapping("/sub/{name}")
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
    
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<ApiResponse<CoffeeSessionData>> deleteCount(
        @PathVariable
        Integer id, HttpSession session){
        
        // 세션에서 삭제하가 구현
        session.removeAttribute("coffee"+id);
        
        return ResponseEntity.ok(ApiResponse.noContent());
    }

}
