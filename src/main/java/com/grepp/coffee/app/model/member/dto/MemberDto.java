package com.grepp.coffee.app.model.member.dto;

import com.grepp.coffee.app.model.auth.code.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("Member")
public class MemberDto {

    private String email;
    private String password;
    private String address;
    private Integer postNum;
    private Role role;
    private Boolean enabled;
}
