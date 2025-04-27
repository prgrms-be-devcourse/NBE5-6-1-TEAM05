package com.grepp.coffee.app.controller;

import com.grepp.coffee.app.model.coffee.CoffeeService;
import com.grepp.coffee.app.model.coffee.dto.CoffeeDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class IndexController {

    private final CoffeeService coffeeService;  // ★ MenuService 주입 추가

    @GetMapping
    public String index(Model model) {
        // ★ 커피 목록 가져오기
        List<CoffeeDto> coffeeList = coffeeService.getAllCoffee();

        // ★ JSP로 넘기기
        model.addAttribute("coffeeList", coffeeList);

        return "index";  // /WEB-INF/views/index.jsp 렌더링
    }
}
