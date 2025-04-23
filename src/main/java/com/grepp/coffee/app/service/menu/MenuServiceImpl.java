//package com.grepp.coffee.app.service.menu;
//
//import com.grepp.coffee.app.model.dto.CoffeeDto;
//import com.grepp.coffee.app.model.entity.Coffee;
//import java.util.List;
//import java.util.stream.Collectors;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class MenuServiceImpl implements MenuService {
//
//    private final CoffeeRepository coffeeRepository;
//
//    // DB에 새로운 커피 메뉴 추가
//    @Override
//    @Transactional
//    public void addMenu(CoffeeDto coffeeDto) {
//
//        coffeeRepository.insert(coffeeDto);
//    }
//
//    // DB에 저장된 커피 메뉴들을 가져옴
//    @Override
//    public List<CoffeeDto> getAllCoffee() {
//        List<Coffee> coffees = coffeeRepository.findAll();
//        return coffees.stream()
//            .map(coffee -> new CoffeeDto(coffee.getId(), coffee.getName(), coffee.getPrice(), coffee.getStock()))
//            .collect(Collectors.toList());
//    }
//
//    // DB에 저장된 커피 메뉴를 수정함
//    @Override
//    @Transactional
//    public void updateMenu(CoffeeDto coffeeDto) {
//
//        coffeeRepository.update(coffeeDto);
//    }
//
//    // DB에 저장된 커피메뉴를 삭제함
//    @Override
//    @Transactional
//    public void deleteMenu(CoffeeDto coffeeDto) {
//
//        coffeeRepository.delete(coffeeDto);
//    }
//}
