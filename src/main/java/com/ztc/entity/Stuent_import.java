package com.ztc.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

@Data
@HeadRowHeight(value = 35)//表头行高
@ContentRowHeight(value = 25)//内容行高
public class Stuent_import implements Serializable {
    @ExcelProperty({"学生信息", "姓名"})
    private String name;
    @ExcelProperty({"学生信息", "年龄"})
    private Integer age;
    @ExcelProperty({"学生信息", "性别"})
    private String sex;
    @ExcelProperty({"学生信息", "电话"})
    @TableField(value = "phone")
    private String phone;

    @ExcelProperty({"学生信息", "QQ"})
    private String qq;
    @ExcelProperty({"学生信息", "微信"})
    @TableField(value = "weixin")
    private String weixin;
    @ExcelIgnore
    private Integer stuStatus;
    @ExcelProperty({"学生信息", "状态"})
    private String status;
    ;
    @ExcelProperty({"学生信息", "咨询经理的id"})
    private Integer netpusherid;
    @ExcelProperty({"学生信息", "咨询经理的名字"})
    private String createUser;
    @ExcelProperty({"学生信息", "咨询师的id"})
    private Integer askerId;
    @ExcelProperty({"学生信息", "咨询师的名字"})
    private String zixunName;

    @ExcelProperty({"学生信息", "创建时间"})
    private String createTime;
    @ExcelProperty({"学生信息", "第一次跟踪时间"})
    private String firstVisitTime;
    @ExcelIgnore
    private Integer isPay;
    @ExcelProperty({"学生信息", "付款状态"})
    private String stringIsPay;
    @ExcelProperty({"学生信息", "付款时间"})
    private String payTime;
    @ExcelProperty({"学生信息", "付款金额"})
    private String money;


}
