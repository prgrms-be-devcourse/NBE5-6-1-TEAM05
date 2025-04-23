package com.grepp.coffee.app.controller.api;

import com.grepp.coffee.app.controller.session.CoffeeSessionData;
import com.grepp.coffee.infra.response.ApiResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderApiController {

    // TODO 잘 굴러가는지 확인

    @PutMapping("/add/{id}")
    public ResponseEntity<ApiResponse<CoffeeSessionData>> addCount(
        @PathVariable
        Integer id, HttpSession session) {

        // Integer에서 바꾸기
        CoffeeSessionData count = (CoffeeSessionData) session.getAttribute("coffee"+id);
        count.setCount(count.getCount()+1);
        session.setAttribute("coffee"+id, count);

        CoffeeSessionData payload = (CoffeeSessionData) session.getAttribute("coffee"+id);

        return ResponseEntity.ok(ApiResponse.success(payload));
    }

    @PutMapping("/sub/{name}")
    public ResponseEntity<ApiResponse<CoffeeSessionData>> subCount(
        @PathVariable
        Integer id, HttpSession session) {

        // Integer에서 바꾸기
        CoffeeSessionData count = (CoffeeSessionData) session.getAttribute("coffee"+id);
        count.setCount(count.getCount()-1);

        CoffeeSessionData payload = (CoffeeSessionData) session.getAttribute("coffee"+id);

        if(count.getCount()==0) {
            session.removeAttribute("coffee"+id);
            return ResponseEntity.ok(ApiResponse.success(payload));
        }


        return ResponseEntity.ok(ApiResponse.success(payload));
    }

    public ResponseEntity<?> deleteCount(){
        return ResponseEntity.ok().build();
    }

}
