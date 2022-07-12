package com.ztc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * @TableName rolemodules
 */
@TableName(value = "rolemodules")
@Data
public class Rolemodules implements Serializable {
    /**
     *
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色编号
     */
    @TableField(value = "RoleId")
    private Integer roleId;

    /**
     * 功能模块编号
     */
    @TableField(value = "ModuleId")
    private Integer moduleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}