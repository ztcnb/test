package com.ztc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * @TableName roles
 */
@TableName(value = "roles")
@Data
public class Roles implements Serializable {
    /**
     * 用户组编号
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色
     */
    @TableField(value = "Name")
    private String name;


}