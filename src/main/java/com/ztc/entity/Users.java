package com.ztc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @TableName users
 */
@TableName(value = "users")
@Data
public class Users implements Serializable {
    /**
     * 编号
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer id;

    /**
     * 登录名
     */
    @TableField(value = "LoginName")
    private String loginName;

    /**
     * 密码
     */
    @TableField(value = "Password")
    private String password;

    /**
     * 是否锁定
     */
    @TableField(value = "IsLockout")
    private String isLockout;

    /**
     * 最后一次登录时间
     */
    @TableField(value = "LastLonginTime")
    private String lastLonginTime;

    /**
     * 账户创立时间
     */
    @TableField(value = "CreateTime")
    private String createTime;

    /**
     * 密码错误次数
     */
    @TableField(value = "PsdWrongTime")
    private String psdWrongTime;

    /**
     * 被锁定时间
     */
    @TableField(value = "LockTime")
    private String lockTime;

    /**
     * 密保邮箱
     */
    @TableField(value = "ProtectEmail")
    private String protectEmail;

    /**
     * 密保手机
     */
    @TableField(value = "ProtectMTel")
    private String protectMTel;

    @TableField(exist = false)
    private String orderBy;
    @TableField(exist = false)
    private int page;
    @TableField(exist = false)
    private String beginTime;

    @TableField(exist = false)
    private String endTime;

    @TableField(exist = false)
    private int limit;

    @TableField(exist = false)
    private int offset;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public int getOffset() {
        return (page - 1) * limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}