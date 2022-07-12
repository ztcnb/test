package com.ztc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @TableName netfollows
 */
@TableName(value = "netfollows")
@Data
public class Netfollows implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    @TableField(value = "studentId")
    private Integer studentId;

    /**
     *
     */
    @TableField(value = "studnetName")
    private String studnetName;

    /**
     *
     */
    @TableField(value = "followTime")
    private String followTime;

    /**
     *
     */
    @TableField(value = "nextFolloTime")
    private String nextFolloTime;

    /**
     *
     */
    @TableField(value = "content")
    private String content;

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
     * 1-电话跟踪 2-QQ跟踪 3-微信跟踪
     */
    @TableField(value = "followType")
    private String followType;

    /**
     *
     */
    @TableField(value = "createTime")
    private String createTime;

    /**
     * 1-已付款 2-正在跟踪 3-失败
     */
    @TableField(value = "folloState")
    private String folloState;

    @TableField(exist = false)
    private String idStr;
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

    public int getOffset() {
        return (page - 1) * limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}