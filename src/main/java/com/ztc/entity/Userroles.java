package com.ztc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * @TableName userroles
 */
@TableName(value = "userroles")
@Data
public class Userroles implements Serializable {
    /**
     * 编号
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户编号
     */
    @TableField(value = "UsersId")
    private Integer usersId;

    /**
     * 角色编号
     */
    @TableField(value = "RoleId")
    private Integer roleId;

    @TableField(exist = false)
    private String name;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}