package com.javasea.order.controller;

import com.javasea.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/{userId}/{commodityCode}/{count}")
    public Boolean create(@PathVariable("userId") String userId,
                          @PathVariable("commodityCode") String commodityCode,
                          @PathVariable("count") Integer count) {

        orderService.create(userId, commodityCode, count);
        return true;
    }

    @GetMapping("/order/test")
    public String test1() {
        return "hello world";
    }
}
