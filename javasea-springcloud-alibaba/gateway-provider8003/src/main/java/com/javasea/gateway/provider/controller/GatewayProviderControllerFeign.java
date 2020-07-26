package com.javasea.gateway.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName GatewayProviderController
 * @Description TODO
 * @Author longxiaonan@163.com
 * @Date 2020/3/17 0017 16:44
 */
@RestController
@RequestMapping("/feign-test")
public class GatewayProviderControllerFeign {

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/hi/{message}")
    public String provider(@PathVariable String message) {
        return serverPort + " " + message;
    }

}
