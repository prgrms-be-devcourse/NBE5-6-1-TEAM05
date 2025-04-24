package com.grepp.coffee.app.controller.web.member.payload;

import com.grepp.coffee.app.model.dto.MemberDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupRequest {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 4, max = 10)
    private String password;
    @NotBlank
    private String address;
    @Min(10000)
    @Max(99999)
    private Integer postNum;
    
    public MemberDto toDto(){

        MemberDto memberDto = new MemberDto();
        memberDto.setPassword(password);
        memberDto.setEmail(email);
        memberDto.setAddress(address);
        memberDto.setPostNum(postNum);

        return memberDto;
    }
}
