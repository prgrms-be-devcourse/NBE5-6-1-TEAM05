package com.grepp.coffee.app.controller.web.admin;

import com.grepp.coffee.app.controller.web.admin.payload.CoffeeRegistRequest;
import com.grepp.coffee.app.model.admin.ManageOrderService;
import com.grepp.coffee.app.model.coffee.dto.CoffeeDto;
import com.grepp.coffee.app.model.coffee.dto.CoffeeImgDto;
import com.grepp.coffee.app.model.member.MemberService;
import com.grepp.coffee.app.model.coffee.CoffeeService;
import com.grepp.coffee.app.model.order.OrderService;
import com.grepp.coffee.app.model.order.dto.DetailedOrderDto;
import com.grepp.coffee.app.model.order.dto.OrderDto;
import com.grepp.coffee.infra.error.exceptions.CommonException;
import com.grepp.coffee.infra.response.ResponseCode;
import jakarta.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    private final ManageOrderService manageOrderService;
    private final CoffeeService coffeeService;
    private final OrderService orderService;

    @GetMapping
    public String admin(Model model) {

        List<CoffeeDto> coffeeDtos = coffeeService.getAllCoffee();
        model.addAttribute("coffeeDtos", coffeeDtos);

        int todayOrder=orderService.getTodayOrderCount();
        int delivered = orderService.getDeliveredOrderCount();
        int undelivered = orderService.getUndeliveredOrderCount();

        model.addAttribute("todayOrder", todayOrder);
        model.addAttribute("deliveredOrder", delivered);
        model.addAttribute("undeliveredOrder", undelivered);

        return "admin/adminpage";
    }


    @GetMapping("order/list")
    public String showOrders(Model model){

        List<OrderDto> orderDtos= manageOrderService.getOrders();

        Map<OrderDto, List<DetailedOrderDto>> orderMap = new LinkedHashMap<>();
        orderDtos.forEach(orderDto -> {
            List<DetailedOrderDto> detailedOrderDtos = manageOrderService.getDetailedOrders(orderDto.getOrderNum());
            orderMap.put(orderDto, detailedOrderDtos);
        });

        model.addAttribute("orderMap", orderMap);

        return "admin/order-list";
    }



    @GetMapping("menu/list")
    public String showMenus(Model model){
        List<CoffeeDto> coffeeDtos = coffeeService.getAllCoffee();

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

        if(coffeeService.addMenu(form.getThumbnail(),form.toDto())){
            return "redirect:/admin/menu/list";
        }
        else{
            throw new CommonException(ResponseCode.BAD_REQUEST);
        }
    }

    @GetMapping("menu/update/{id}")
    public String updateMenu(@PathVariable Integer id, CoffeeRegistRequest request
        ,Model model){

        CoffeeDto update = coffeeService.getCoffee(new CoffeeDto(id,null,null,null));
        request.setCoffeeId(update.getCoffeeId());
        request.setCoffeeName(update.getCoffeeName());
        request.setPrice(update.getPrice());
        request.setStock(update.getStock());

        if(update.getImages() != null && !update.getImages().isEmpty()){
            model.addAttribute("image",update.getImages().getFirst());
        }
        model.addAttribute("coffeeDto", update);
        model.addAttribute("method", "update");

        return "admin/menu-update";
    }

    @PostMapping("menu/update/{id}")
    public String registMenu(@PathVariable Integer id, CoffeeRegistRequest request, BindingResult bindingResult
        ,Model model){

        if(bindingResult.hasErrors()){
            return "redirect:menu/menu-update";
        }

        request.setCoffeeId(id);
        if(coffeeService.updateMenu(request.getThumbnail(),request.toDto())){
            return "redirect:/admin/menu/list";
        }else{
            throw new CommonException(ResponseCode.BAD_REQUEST);
        }

    }



}
