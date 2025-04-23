// Member와 MemberService가 없어서 주석 처리



//package com.grepp.coffee.app.model.auth;
//
//
//import com.grepp.coffee.app.model.auth.domain.Principal;
//import java.util.ArrayList;
//import java.util.List;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//@Transactional(readOnly = true)
//public class AuthService implements UserDetailsService {
//
//    private final MemberRepository memberRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username){
//
//        Member member = memberRepository.findById(username)
//                            .orElseThrow(() -> new UsernameNotFoundException(username));
//
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(member.getRole().name()));
//
//        return Principal.createPrincipal(member, authorities);
//    }
//
//
//}
