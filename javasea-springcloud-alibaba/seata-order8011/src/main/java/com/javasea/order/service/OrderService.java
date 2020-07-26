package com.javasea.order.service;

import com.javasea.order.dao.OrderMapper;
import com.javasea.order.entity.Order;
import com.javasea.order.feign.AccountFeignClient;
import com.javasea.order.utils.SnowflakeIdWorker;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

@Slf4j
@Service
public class OrderService {
    @Resource
    private AccountFeignClient accountFeignClient;

    @Resource
    private OrderMapper orderMapper;

    @Transactional(rollbackFor = Exception.class)
    public void create(String userId, String commodityCode, Integer count) {
        log.info("开始全局事务，XID = " + RootContext.getXID());
        // 数量乘以价格
        int orderMoney = count * 10;
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(orderMoney);

        //创建订单
        orderMapper.insert(order);
        //账户扣款
        accountFeignClient.debit(userId, orderMoney);
    }


}
