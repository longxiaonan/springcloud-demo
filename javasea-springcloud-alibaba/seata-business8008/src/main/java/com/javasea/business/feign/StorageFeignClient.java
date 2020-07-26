package com.javasea.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "storage-service")
public interface StorageFeignClient {

    @GetMapping("/deduct/{commodityCode}/{count}")
    Boolean deduct(@PathVariable("commodityCode") String commodityCode,
                   @PathVariable("count") Integer count);
}
