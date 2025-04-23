package com.grepp.coffee.app.model.dto;

import com.grepp.coffee.app.model.dto.code.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private String email;
    private String password;
    private String address;
    private Integer postNum;
    private Role role;
    private Boolean enabled;
}
