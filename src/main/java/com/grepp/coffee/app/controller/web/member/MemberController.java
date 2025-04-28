package com.grepp.coffee.app.controller.web.member;


import com.grepp.coffee.app.controller.web.member.payload.SigninRequest;
import com.grepp.coffee.app.controller.web.member.payload.SignupRequest;
import com.grepp.coffee.app.controller.web.member.payload.UpdateAddressRequest;
import com.grepp.coffee.app.model.auth.code.Role;
import com.grepp.coffee.app.model.coffee.CoffeeService;
import com.grepp.coffee.app.model.coffee.dto.CoffeeDto;
import com.grepp.coffee.app.model.member.dto.MemberDto;
import com.grepp.coffee.app.model.member.MemberService;
import com.grepp.coffee.app.model.order.dto.DetailedOrderDto;
import com.grepp.coffee.app.model.order.dto.MyPageOrderDto;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("member")
public class MemberController {
    
    private final MemberService memberService;
    private final CoffeeService coffeeService;

    @GetMapping("signup")
    public String signup(SignupRequest signupRequest){
        return "member/signup";
    }
    
    @PostMapping("signup")
    public String signup(
        @Valid SignupRequest signupRequest,
        BindingResult bindingResult,
        Model model){
        
        if(bindingResult.hasErrors()){
            return "member/signup";
        }
        
        memberService.signup(signupRequest.toDto(), Role.ROLE_USER);
        return "redirect:/";
    }
    
    @GetMapping("signin")
    public String signin(SigninRequest signinRequest){
        return "member/signin";
    }
    
    
    @GetMapping("mypage")
    public String mypage(Authentication authentication, Model model){
        log.info("authentication : {}", authentication);
        String userId = authentication.getName();
        MemberDto memberDto = memberService.findById(userId);
        model.addAttribute("member", memberDto);

        // 1. email 로 주문 목록 가져오기
        List<MyPageOrderDto> myPageOrders = memberService.detailedOrderListByEmail(userId);

        // 2. 화면에 넘길 데이터 구조 만들기
        Map<Integer, List<Map<String, Object>>> orderDetailMap = new HashMap<>();

        for(MyPageOrderDto order : myPageOrders){
            List<Map<String, Object>> details = new ArrayList<>();
            for (DetailedOrderDto detail : order.getDetailedOrders()){
                CoffeeDto coffee = coffeeService.getCoffee(detail.getCoffeeId());
                Map<String, Object> detailInfo = new HashMap<>();
                detailInfo.put("coffeeName", coffee.getCoffeeName());
                detailInfo.put("coffeeImage", coffee.getImages());
                detailInfo.put("quantity", detail.getQuantity());
                details.add(detailInfo);
            }
            orderDetailMap.put(order.getOrderId(), details);
        }

        // 3. model 에 같이 담아서 jsp 로 넘김
        model.addAttribute("orders", myPageOrders);
        model.addAttribute("detailedOrders", orderDetailMap);

        return "member/mypage";
    }

    @GetMapping("mypage/update")
    public String updateMypage(Authentication authentication, UpdateAddressRequest updateAddressRequest, Model model){
        String userId = authentication.getName();
        model.addAttribute("email", userId);
        return "member/update-address";
    }

    @PostMapping("mypage/update")
    public String updateMypage(Authentication authentication, UpdateAddressRequest updateAddressRequest,BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "redirect:/member/mypage/update";
        }

        String userId = authentication.getName();

        if(memberService.updateAddress(userId, updateAddressRequest.getAddress(), updateAddressRequest.getPostNum()))
            return "redirect:/member/mypage";
        else
            return "redirect:/member/mypage/update";
    }

    
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or authentication.name == #id")
    @GetMapping("{id}")
    public String get(@PathVariable String id, Model model){
        MemberDto memberDto = memberService.findById(id);
        model.addAttribute("member", memberDto);

        return "member/mypage";
    }
}
