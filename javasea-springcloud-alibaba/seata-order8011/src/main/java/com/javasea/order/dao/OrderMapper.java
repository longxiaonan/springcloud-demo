package com.javasea.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javasea.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
