package com.grepp.coffee.app.model.repository;

import com.grepp.coffee.app.model.dto.CoffeeDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
    "file:src/main/webapp/WEB-INF/spring/root-context.xml",
    "file:src/main/webapp/WEB-INF/spring/servlet-context.xml"
})
@Slf4j
class CoffeeRepositoryTest {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Test
    public void selectByCoffeeId() {
        log.info("{}", coffeeRepository.selectByCoffeeId(1));
    }

    @Test
    public void selectAllCoffee() {
        log.info("{}", coffeeRepository.selectAllCoffee());
    }

    @Test
    public void insertCoffee() {
        CoffeeDto dto = new CoffeeDto();
        dto.setCoffeeName("maxim");
        dto.setPrice(1500);
        dto.setStock(30);
        coffeeRepository.insertCoffee(dto);
        log.info("{}", dto);
    }

    @Test
    public void updateCoffee() {
        CoffeeDto dto = new CoffeeDto();
        dto.setCoffeeId(4);
        dto.setCoffeeName("kanu");
        dto.setPrice(2500);
        coffeeRepository.updateCoffee(dto);
        log.info("{}", dto);
    }
}