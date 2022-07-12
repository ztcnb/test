package com.ztc.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;


@Data
@HeadRowHeight(value = 35)
@ContentRowHeight(value = 25)
public class Netfollows_export {
    @ExcelProperty({"跟踪学生信息", "编号"})
    private Integer studentId;
    @ExcelProperty({"跟踪学生信息", "姓名"})
    private String studnetName;
    @ExcelProperty({"跟踪学生信息", "内容"})
    private Integer content;
    @ExcelProperty({"跟踪学生信息", "id"})
    private String userId;
    @ExcelProperty({"跟踪学生信息", "姓名"})
    @TableField(value = "userName")
    private String userName;
    @ExcelProperty({"跟踪学生信息", "创建时间"})
    private String createTime;
    @ExcelProperty({"跟踪学生信息", "下一次跟踪时间"})
    private String nextFolloTime;
    @ExcelProperty({"跟踪学生信息", "第一次跟踪时间"})
    private String followTime;
    @ExcelIgnore
    private Integer stuStatus;
    @ExcelProperty({"跟踪学生信息", "状态"})
    private String followType;

    public String getStatusName() {
        String followType = "";
        if (stuStatus == 1) {
            return followType = "电话跟踪";
        }
        if (stuStatus == 2) {
            return followType = "微信跟踪";
        }

        return followType = "QQ跟踪";
    }

    @ExcelIgnore
    private Integer folloState;
    @ExcelProperty({"跟踪学生信息", "跟踪状态"})
    private String stringIsPay;

    public String getStringIsPay() {
        String stringIsPay = "";
        if (folloState == 1) {
            return stringIsPay = "已付款";
        }
        if (stuStatus == 2) {
            return followType = "正在跟踪";
        } else {
            return stringIsPay = "失败";
        }
    }

}
