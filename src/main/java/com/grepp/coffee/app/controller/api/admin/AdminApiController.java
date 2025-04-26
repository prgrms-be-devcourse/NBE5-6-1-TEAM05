package com.grepp.coffee.app.controller.api.admin;

import com.grepp.coffee.app.model.coffee.dto.CoffeeDto;
import com.grepp.coffee.app.model.coffee.CoffeeService;
import com.grepp.coffee.infra.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/admin")
public class AdminApiController {

    private final CoffeeService coffeeService;

    @DeleteMapping("menu/delete/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteMenu(@PathVariable Integer id
        , Model model){

        return ResponseEntity.ok(ApiResponse.success(
            coffeeService.deleteMenu(new CoffeeDto(id,null,null,null))
        ));
    }

}
