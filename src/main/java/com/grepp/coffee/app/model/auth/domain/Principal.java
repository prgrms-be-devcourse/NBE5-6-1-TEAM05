package com.grepp.coffee.app.model.auth.domain;


import com.grepp.coffee.app.model.dto.MemberDto;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class Principal extends User {

    public Principal(String username, String password,
        Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public static Principal createPrincipal(MemberDto member,
        List<SimpleGrantedAuthority> authorities){
        return new Principal(member.getEmail(), member.getPassword(), authorities);
    }
}
