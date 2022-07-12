package com.ztc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @TableName message
 */
@TableName(value = "message")
@Data
public class Message implements Serializable {
    /**
     *
     */
    @TableId(value = "askerId", type = IdType.AUTO)
    private Integer askerId;

    /**
     *
     */
    @TableField(value = "content")
    private String content;

    /**
     *
     */
    @TableField(value = "senderId")
    private Integer senderId;

    /**
     *
     */
    @TableField(value = "senderName")
    private String senderName;

    /**
     *
     */
    @TableField(value = "receiverId")
    private Integer receiverId;

    /**
     *
     */
    @TableField(value = "receiverName")
    private String receiverName;

    /**
     *
     */
    @TableField(value = "sendTime")
    private String sendTime;

    /**
     *
     */
    @TableField(value = "isRead")
    private String isRead;

    @TableField(exist = false)
    private String idStr;
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