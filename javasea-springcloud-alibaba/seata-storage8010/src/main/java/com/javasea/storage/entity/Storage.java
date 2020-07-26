package com.javasea.storage.entity;

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
@TableName("storage_tbl")
public class Storage implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value ="id",type = IdType.AUTO)
    private Integer id;
    private String commodityCode;
    private Integer count;
}
