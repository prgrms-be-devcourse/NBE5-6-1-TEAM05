package com.grepp.coffee.app.controller.web.member;


import com.grepp.coffee.app.controller.web.member.payload.SigninRequest;
import com.grepp.coffee.app.controller.web.member.payload.SignupRequest;
import com.grepp.coffee.app.controller.web.member.payload.UpdateAddressRequest;
import com.grepp.coffee.app.model.admin.ManageOrderService;
import com.grepp.coffee.app.model.auth.code.Role;
import com.grepp.coffee.app.model.member.dto.MemberDto;
import com.grepp.coffee.app.model.member.MemberService;
import com.grepp.coffee.app.model.order.dto.DetailedOrderDto;
import com.grepp.coffee.app.model.order.dto.OrderDto;
import jakarta.validation.Valid;
import java.util.LinkedHashMap;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("member")
public class MemberController {
    
    private final MemberService memberService;

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


        List<OrderDto> orderDtos= memberService.orderListByEmail(userId);
        List<DetailedOrderDto> detailedOrderDtos = memberService.detailedOrderListByEmail(userId);

        model.addAttribute("orders", orderDtos);
        model.addAttribute("detailedOrders", detailedOrderDtos);

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

        if(memberService.updateAddressByEmail(userId, updateAddressRequest.getAddress()))
            return "member/mypage";
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
