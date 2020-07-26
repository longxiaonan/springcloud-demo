package com.javasea.account.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.javasea.account.dao.AccountMapper;
import com.javasea.account.entity.Account;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class AccountService {

    private static final String ERROR_USER_ID = "1002";

    @Resource
    private AccountMapper accountMapper;

    @Transactional(rollbackFor = Exception.class)
    public void debit(String userId, Integer num) {
        log.info("开始全局事务，XID = " + RootContext.getXID());
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.setEntity(new Account().setUserId(userId));

        Account account = accountMapper.selectOne(wrapper);
        account.setMoney(account.getMoney() - num);
        accountMapper.updateById(account);

        // 抛出异常用于模拟服务报错进行回滚
        if (ERROR_USER_ID.equals(userId)) {
            throw new RuntimeException("account branch exception");
        }
    }
}
