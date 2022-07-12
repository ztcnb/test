package com.ztc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * @TableName askers
 */
@TableName(value = "askers")
@Data
public class Askers implements Serializable {
    /**
     *
     */
    @TableId(value = "askerId", type = IdType.AUTO)
    private Integer askerId;

    /**
     *
     */
    @TableField(value = "askerName")
    private String askerName;

    /**
     *
     */
    @TableField(value = "weight")
    private String weight;

    @TableField(exist = false)
    private int page;

    private int limit;

    @TableField(exist = false)
    private int offset;

    public int getOffset() {
        return (page - 1) * limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}