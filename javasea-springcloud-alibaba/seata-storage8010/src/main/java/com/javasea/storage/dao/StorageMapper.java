package com.javasea.storage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javasea.storage.entity.Storage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageMapper extends BaseMapper<Storage> {
}
