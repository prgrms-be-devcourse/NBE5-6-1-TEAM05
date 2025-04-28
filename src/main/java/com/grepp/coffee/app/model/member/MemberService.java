package com.grepp.coffee.app.model.member;

import com.grepp.coffee.app.model.auth.code.Role;
import com.grepp.coffee.app.model.order.OrderRepository;
import com.grepp.coffee.app.model.order.dto.DetailedOrderDto;
import com.grepp.coffee.app.model.order.dto.MyPageOrderDto;
import com.grepp.coffee.app.model.order.dto.OrderDto;
import com.grepp.coffee.app.model.member.dto.MemberDto;
import com.grepp.coffee.app.model.member.dto.PrincipalDto;
import com.grepp.coffee.infra.error.exceptions.CommonException;
import com.grepp.coffee.infra.response.ResponseCode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService{

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    // ==================== 인증 및 가입 관련 ==================== //
    @Transactional
    public void signup(MemberDto dto, Role role) {
        if(memberRepository.existsByEmail(dto.getEmail()))
            throw new CommonException(ResponseCode.BAD_REQUEST);

        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(encodedPassword);

        dto.setRole(role);
        memberRepository.insertMember(dto);
    }

    public PrincipalDto signin(String userId, String password) {

        Optional<MemberDto> optional = memberRepository.selectByEmail(userId);

        if(optional.isEmpty())
            return PrincipalDto.ANONYMOUS;

        MemberDto member = optional.get();

        if(!member.getPassword().equals(password))
            return PrincipalDto.ANONYMOUS;

        return new PrincipalDto(userId, List.of(Role.ROLE_USER), LocalDateTime.now());
    }

    public Boolean isDuplicatedId(String id) {
        return memberRepository.existsByEmail(id);
    }

    public MemberDto findById(String userId) {
        return memberRepository.selectByEmail(userId)
            .orElseThrow(() -> new CommonException(ResponseCode.BAD_REQUEST));
    }

    // ==================== 마이페이지 관련 ==================== //
    // Update address
    public boolean updateAddress(String email, String address, int postNum) {
        return memberRepository.updateAddress(email, address, postNum);
    }

    // Get member's order lists
    public List<OrderDto> orderListByEmail(String email) {
        return  null;
    }

    // Get member's order details
    public List<MyPageOrderDto> detailedOrderListByEmail(String email) {
        return orderRepository.getDetailedOrdersByEmail(email);
    }
}
