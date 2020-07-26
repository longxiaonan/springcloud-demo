package com.javasea.business.service;

import com.javasea.business.feign.OrderFeignClient;
import com.javasea.business.feign.StorageFeignClient;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class BusinessService {

    @Resource
    private StorageFeignClient storageFeignClient;
    @Resource
    private OrderFeignClient orderFeignClient;

    /**
     * 减库存，下订单
     * @param userId
     * @param commodityCode
     * @param orderCount
     */
    @GlobalTransactional(timeoutMills = 300000)
    public void purchase(String userId, String commodityCode, int orderCount) {
        log.info("开始全局事务，XID = " + RootContext.getXID());
        // 减库存
        storageFeignClient.deduct(commodityCode, orderCount);
        // 创建订单
        orderFeignClient.create(userId, commodityCode, orderCount);
    }
}
