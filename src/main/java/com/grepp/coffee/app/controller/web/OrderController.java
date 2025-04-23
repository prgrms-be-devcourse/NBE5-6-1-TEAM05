package com.grepp.coffee.app.controller.web;

import com.grepp.coffee.app.controller.session.CoffeeSessionData;
import com.grepp.coffee.app.controller.web.payload.OrderRequest;

import com.grepp.coffee.app.model.dto.CoffeeDto;
import com.grepp.coffee.app.service.MenuService;
import com.grepp.coffee.app.service.OrderService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final MenuService menuService;

    @GetMapping
    public String getOrder(OrderRequest request, HttpSession session, Model model) {
        // 커피 데이터 가져오기
        List<CoffeeDto> coffeeDtos = menuService.getAllCoffee();

        // TODO DB 연결하고 확인하기~~
        Map<String, CoffeeSessionData> coffeeCart = new HashMap<>();
        coffeeDtos.forEach(coffee -> {
            String key = "coffee"+coffee.getCoffeeId();
            Object value = session.getAttribute(key);
            coffeeCart.put(key, (CoffeeSessionData) value);
        });

        model.addAttribute("coffeeDtos", coffeeDtos);
        model.addAttribute("coffeeCart", coffeeCart);

        return "order/order";
    }


    // 결제 완료 버튼을 눌렀을 때
    @PostMapping
    public String postOrder(
        @Valid
        OrderRequest request,
        BindingResult bindingResult,
        HttpSession session,
        Model model){

        if(bindingResult.hasErrors()){
            // TODO valid 걸릴 때 어떻게 처리하징
            return "order/order";
        }

        // 커피 이름 가져오기
        // session에서 이름으로 조회해서 수량 받아오기

        // order에 업데이트 하기
        // orderDto를 사용해서 넘기기


        return "order/order";
    }

}
