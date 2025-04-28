package com.grepp.coffee.app.controller.api.member;

import com.grepp.coffee.app.model.admin.ManageOrderService;
import com.grepp.coffee.app.model.member.MemberService;
import com.grepp.coffee.infra.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/member")
public class MemberApiController {
    
    private final MemberService memberService;
    private final ManageOrderService manageOrderService;
    
    @GetMapping("exists/{email}")
    public ResponseEntity<ApiResponse<Boolean>> existsId(@PathVariable String email){
        return ResponseEntity.ok(ApiResponse.success(
            memberService.isDuplicatedId(email)
        ));
    }

    @DeleteMapping("order/delete/{orderNum}")
    public ResponseEntity<ApiResponse<Boolean>> deleteOrder(@PathVariable Integer orderNum
        , Model model){

        return ResponseEntity.ok(ApiResponse.success(
            manageOrderService.cancelOrder(orderNum)
        ));
    }
}
