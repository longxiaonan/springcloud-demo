package com.javasea.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigTestController
 * @Description @RefreshScope 支持nacos根据配置动态刷新功能，也就是修改nacos的配置文件并发布后，该controller会读取到最新的配置
 * @Author longxiaonan@163.com
 * @Date 2020/3/17 0017 13:04
 */
@RestController
@RefreshScope
public class ConfigTestController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
