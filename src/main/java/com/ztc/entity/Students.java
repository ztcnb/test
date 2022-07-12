package com.ztc.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @TableName students
 */
@TableName(value = "students")
@Data
public class Students implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 字名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private String sex;

    /**
     * 手机
     */
    @TableField(value = "phone")
    private Integer phone;

    /**
     *
     */
    @TableField(value = "qq")
    private Integer qq;

    /**
     *
     */
    @TableField(value = "weixin")
    private String weixin;

    /**
     * 1-已录入 2-已缴费 3-失败
     */
    @TableField(value = "stuStatus")
    private String stuStatus;
    /**
     * netpusherId是 网络咨询或者咨询经理的id跟users的id对 应
     */
    @TableField(value = "netpusherid")
    private Integer netpusherid;

    /**
     * 网络咨询师或网络经理的名字
     */
    @TableField(value = "createUser")
    private String createUser;

    /**
     * 咨询师的Id跟users的id和askers的askerId的对应
     */
    @TableField(value = "askerId")
    private Integer askerId;

    /**
     * 咨询师的name
     */
    @TableField(value = "zixunName")
    private String zixunName;

    /**
     * 创建时间
     */
    @TableField(value = "createTime")
    private String createTime;

    /**
     * 是否跟踪
     */
    @TableField(value = "isReturnVist")
    private String isReturnVist;

    /**
     * 第一时间跟踪
     */
    @TableField(value = "firstVisitTime")
    private String firstVisitTime;

    /**
     * 0-未付款 1-已付款
     */
    @TableField(value = "isPay")
    private Integer isPay;

    /**
     * 付款时间
     */
    @TableField(value = "payTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String payTime;

    /**
     * 付款金额
     */
    @TableField(value = "money")
    private String money;


    @TableField(exist = false)
    private String followTime;

    @TableField(exist = false)
    private String nextFolloTime;

    @TableField(exist = false)
    private String content;

    @TableField(exist = false)
    private Integer userId;

    @TableField(exist = false)
    private String userName;

    @TableField(exist = false)
    private String followType;

    @TableField(exist = false)
    private String folloState;

    @TableField(exist = false)
    private Integer usersId;
    @TableField(value = "isValid")
    private int isValid;
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