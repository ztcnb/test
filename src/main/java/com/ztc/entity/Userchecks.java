package com.ztc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @TableName userchecks
 */
@TableName(value = "userchecks")
@Data
public class Userchecks implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    @TableField(value = "userId")
    private Integer userId;

    /**
     *
     */
    @TableField(value = "userName")
    private String userName;

    /**
     *
     */
    @TableField(value = "checkInTime")
    private Date checkInTime;

    /**
     *
     */
    @TableField(value = "checkOutTime")
    private Date checkOutTime;

    /**
     *
     */
    @TableField(value = "checkState")
    private String checkState;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}