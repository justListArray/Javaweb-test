package com.example.test5;

import com.example.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderServiceTest {

    @Test
    public void testPlaceOrder() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderService orderService = (OrderService) context.getBean("orderService");
        orderService.placeOrder();
    }
}
