package com.javasea.account.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javasea.account.entity.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
