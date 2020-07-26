package com.javasea.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "order-service")
public interface OrderFeignClient {

    @GetMapping("/order/{userId}/{commodityCode}/{count}")
    Boolean create(@PathVariable("userId") String userId,
                @PathVariable("commodityCode") String commodityCode,
                @PathVariable("count") Integer count);
}
