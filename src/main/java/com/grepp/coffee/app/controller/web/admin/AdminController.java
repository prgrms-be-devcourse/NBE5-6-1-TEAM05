package com.grepp.coffee.app.controller.web.admin;

import com.grepp.coffee.app.controller.web.admin.payload.CoffeeRegistRequest;
import com.grepp.coffee.app.model.dto.CoffeeDto;
import com.grepp.coffee.app.service.MemberService;
import com.grepp.coffee.app.service.MenuService;
import com.grepp.coffee.app.service.OrderService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("admin")
public class AdminController {

    private final MemberService memberService;
    private final OrderService orderService;
    private final MenuService menuService;

    @GetMapping
    public String admin(Model model) {

        return "admin/adminpage";
    }


    @GetMapping("order-list")
    public String showOrders(Model model){

        // service 작성 되는 거 보고 데이터 받아서 뿌리기

        return "member/admin/order-list";
    }

    @GetMapping("menu/list")
    public String showMenus(Model model){
        List<CoffeeDto> coffeeDtos = menuService.getAllCoffee();

        model.addAttribute("coffeeDtos", coffeeDtos);
        return "admin/menu-list";
    }

    @GetMapping("menu/regist")
    public String registMenu(CoffeeRegistRequest form, Model model){

        return "admin/menu-regist";
    }

    @PostMapping("menu/regist")
    public String registMenu(@Valid CoffeeRegistRequest form, BindingResult bindingResult
        ,Model model){

        if(bindingResult.hasErrors()){
            return "admin/menu-regist";
        }

        menuService.addMenu(form.toDto());
        return "redirect:/admin/menu/list";
    }

    @GetMapping("menu/update/{id}")
    public String updateMenu(@PathVariable Integer id, CoffeeRegistRequest request
        ,Model model){

        CoffeeDto update = menuService.getCoffee(new CoffeeDto(id,null,null,null));
        request.setCoffeeId(update.getCoffeeId());
        request.setCoffeeName(update.getCoffeeName());
        request.setPrice(update.getPrice());
        request.setStock(update.getStock());
        model.addAttribute("coffeeDto", update);
        model.addAttribute("method", "update");

        return "admin/menu-update";
    }

    @PostMapping("menu/update/{id}")
    public String registMenu(@PathVariable Integer id, CoffeeRegistRequest request, BindingResult bindingResult
        ,Model model){

        if(bindingResult.hasErrors()){
            return "menu/update/{id}";
        }

        log.info("{}",request.getStock());

        menuService.updateMenu(request.toDto());

        return "redirect:/admin/menu/list";
    }



}
