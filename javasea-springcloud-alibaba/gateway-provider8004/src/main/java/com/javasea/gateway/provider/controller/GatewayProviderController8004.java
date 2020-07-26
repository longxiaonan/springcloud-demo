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
@RequestMapping("/provider")
public class GatewayProviderController8004 {

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/provider")
    public String provider() {
        return "provider";
    }

    @GetMapping("/get/{id}")
    public String get(@PathVariable String id) {
        return "get/" + id;
    }

    @GetMapping("/serverPort")
    public Integer get2() {
        return serverPort;
    }
}
