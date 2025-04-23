package com.grepp.coffee.app.model.dto;

import com.grepp.coffee.app.model.auth.code.Role;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.type.Alias;

@Alias("MEMBER_PRINCIPAL")
public record PrincipalDto(
    String userId,
    List<Role> Roles,
    LocalDateTime loginedAt
) {
    
    public static final PrincipalDto ANONYMOUS = new PrincipalDto(
        "anonymous",
        List.of(Role.ANONYMOUS),
        LocalDateTime.now());
}
