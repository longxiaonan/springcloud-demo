package com.javasea.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("order_tbl")
public class Order implements Serializable {
    private static final long serialVersionUID = 123423L;
    @TableId(value ="id",type = IdType.AUTO)
    private Long id;
    private String userId;
    private String commodityCode;
    private Integer money;
    private Integer count;

}
