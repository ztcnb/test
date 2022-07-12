package com.ztc.entity;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

@Data
@HeadRowHeight(value = 35)
@ContentRowHeight(value = 25)
public class Student_export implements Serializable {

    @ExcelProperty({"学生信息", "编号"})
    private Integer id;

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

    /**
     * 1-已录入未分配|2-已分配咨询师|3-正在跟踪|4-跟踪结束(已缴费)|5-跟踪结束(失败)
     */

    @ExcelIgnore
    private Integer stuStatus;

    @ExcelProperty({"学生信息", "状态"})
    private String statusName;

    public String getStatusName() {
        String statusName = "";
        if (stuStatus == 1) {
            return statusName = "已录入未分配";
        }
        if (stuStatus == 2) {
            return statusName = "已分配咨询师";
        }
        if (stuStatus == 3) {
            return statusName = "正在跟踪";
        }
        if (stuStatus == 4) {
            return statusName = "跟踪结束(已缴费)";
        }
        return statusName = "跟踪结束(失败)";
    }


    @ExcelProperty({"学生信息", "咨询经理的id"})
    private Integer netpusherId;


    @ExcelProperty({"学生信息", "咨询经理的名字"})
    private String createUser;

    @ExcelProperty({"学生信息", "咨询师的id"})

    private Integer askerId;


    @ExcelProperty({"学生信息", "咨询师的名字"})

    private String ziXunName;

    @ExcelIgnore
    private Integer isValid;
    @ExcelProperty({"学生信息", "有效状态"})
    private String stringValid;

    public String getStringValid() {
        String stringValid = "";
        if (isValid == 0) {
            return stringValid = "无效";
        } else {
            return stringValid = "有效";
        }
    }


    @ExcelProperty({"学生信息", "创建时间"})
    private String createTime;


    @ExcelProperty({"学生信息", "第一次跟踪时间"})
    private String firstVisitTime;

    /**
     * 是否付款--0-未付款|1-已付款
     */
    @ExcelIgnore
    private Integer isPay;
    @ExcelProperty({"学生信息", "付款状态"})
    private String stringIsPay;

    public String getStringIsPay() {
        String stringIsPay = "";
        if (isPay == 0) {
            return stringIsPay = "未付款";
        } else {
            return stringIsPay = "已付款";
        }
    }

    @ExcelProperty({"学生信息", "付款时间"})
    private String payTime;
    @ExcelProperty({"学生信息", "付款金额"})
    private String money;
}
