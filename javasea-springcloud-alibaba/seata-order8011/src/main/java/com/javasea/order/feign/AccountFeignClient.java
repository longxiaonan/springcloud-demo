package com.javasea.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-service")
public interface AccountFeignClient {

    @GetMapping("/debit/{userId}/{money}")
    Boolean debit(@PathVariable(value = "userId") String userId, @PathVariable(value = "money") Integer money);
}
