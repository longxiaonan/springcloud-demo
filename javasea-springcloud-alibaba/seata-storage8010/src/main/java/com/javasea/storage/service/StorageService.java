package com.javasea.storage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.javasea.storage.dao.StorageMapper;
import com.javasea.storage.entity.Storage;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Transactional
    public void deduct(String commodityCode, int count) {
        log.info("开始分支事务，XID = " + RootContext.getXID());
        QueryWrapper<Storage> wrapper = new QueryWrapper<>();
        wrapper.setEntity(new Storage().setCommodityCode(commodityCode));

        Storage storage = storageMapper.selectOne(wrapper);
        storage.setCount(storage.getCount() - count);

        storageMapper.updateById(storage);
    }
}
