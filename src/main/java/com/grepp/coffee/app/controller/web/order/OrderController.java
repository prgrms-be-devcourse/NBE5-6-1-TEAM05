package com.grepp.coffee.app.controller.web.order;

import com.grepp.coffee.app.controller.session.CoffeeSessionData;
import com.grepp.coffee.app.controller.web.order.payload.OrderRequest;

import com.grepp.coffee.app.model.admin.ManageOrderService;
import com.grepp.coffee.app.model.coffee.dto.CoffeeDto;
import com.grepp.coffee.app.model.member.MemberService;
import com.grepp.coffee.app.model.member.dto.MemberDto;
import com.grepp.coffee.app.model.order.dto.DetailedOrderDto;
import com.grepp.coffee.app.model.order.dto.OrderDto;
import com.grepp.coffee.app.model.coffee.CoffeeService;
import com.grepp.coffee.app.model.order.OrderService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
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
    private final CoffeeService coffeeService;
    private final MemberService memberService;

    @GetMapping
    public String getOrder(OrderRequest request, HttpSession session, Model model) {
        // 커피 데이터 가져오기
        List<CoffeeDto> coffeeDtos = coffeeService.getAllCoffee();

        //세션 데이터 가져오기
        Map<String, CoffeeSessionData> coffeeCart = new HashMap<>();
        for(CoffeeDto coffee : coffeeDtos) {
            String key = "coffee"+coffee.getCoffeeId();
            Object value = session.getAttribute(key);
            if(value !=null){
                coffeeCart.put(key, (CoffeeSessionData) value);
            }
        }

        model.addAttribute("coffeeDtos", coffeeDtos);
        model.addAttribute("coffeeCart", coffeeCart);

        return "order/order";
    }

    @PostMapping
    public String getOrder(OrderRequest request) {

        return "redirect:order/payment";
    }

    @GetMapping("payment")
    public String payment(Authentication authentication ,OrderRequest orderRequest, HttpSession session, Model model) {

        // 커피 데이터 가져오기
        List<CoffeeDto> coffeeDtos = coffeeService.getAllCoffee();
        int count=0;

        // 장바구니 데이터 가져오기
        Map<String, CoffeeSessionData> coffeeCart = new HashMap<>();
        for(CoffeeDto coffee : coffeeDtos) {
            String key = "coffee"+coffee.getCoffeeId();
            Object value = session.getAttribute(key);
            if(value !=null){
                coffeeCart.put(key, (CoffeeSessionData) value);
                count+=coffee.getPrice()*((CoffeeSessionData) value).getCoffeeCount();
            }
        }

        model.addAttribute("total", count);
        model.addAttribute("coffeeCart", coffeeCart);

        // 미리 입력할 데이터 넣기
        String email= authentication.getName();
        log.info(email);
        MemberDto user = memberService.findById(email);
        orderRequest.setEmail(email);
        orderRequest.setAddress(user.getAddress());
        orderRequest.setPostNum(user.getPostNum());
        log.info("address: {}");


        model.addAttribute("orderRequest", orderRequest);
        return "order/payment";
    }

    // 결제 하기 버튼을 눌렀을 때
    @PostMapping("payment")
    public String postOrder(
        @Valid
        OrderRequest orderRequest,
        BindingResult bindingResult,
        HttpSession session,
        Model model){

        if(bindingResult.hasErrors()){
            return "order/order";
        }

        // OrderDto 만들기
        OrderDto orderDto = orderRequest.toOrderDto();

        log.info("{}",orderDto.getPostNum());


        List<DetailedOrderDto> details = new ArrayList<>();

        // 커피 모두 가져오기
        List<CoffeeDto> coffeeDtos = coffeeService.getAllCoffee();
        // session에서 아이디로 조회해서 수량 받아와 DatailedOrderDto List에 추가
        coffeeDtos.forEach(coffee -> {
            String key = "coffee"+coffee.getCoffeeId();
            CoffeeSessionData value = (CoffeeSessionData) session.getAttribute(key);
            if(value!=null){
                DetailedOrderDto detailedOrderDto = new DetailedOrderDto();
                detailedOrderDto.setOrderNum(null);
                detailedOrderDto.setDetailNum(null);
                detailedOrderDto.setCoffeeId(coffee.getCoffeeId());

                detailedOrderDto.setQuantity(value.getCoffeeCount());

                details.add(detailedOrderDto);
            }
        });

        // 서비스론 넘겨 추가 하기
        if(orderService.processOrder(orderDto, details)){
            coffeeDtos.forEach(coffee -> {
                String key = "coffee"+coffee.getCoffeeId();
                session.removeAttribute(key);
            });
            return "order/endorder";
        }

        else{
            return "order/payment";
        }
    }



}
