package com.grepp.coffee.app.controller.web.member.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SigninRequest {


    @NotBlank
    @Email
    private String email;
    
    @NotBlank
    @Size(min = 4, max = 10)
    private String password;
    
}
