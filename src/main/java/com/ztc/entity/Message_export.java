package com.ztc.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

@Data
@HeadRowHeight(value = 35)
@ContentRowHeight(value = 25)
public class Message_export {

    @ExcelProperty({"信息表", "编号"})
    private Integer askerId;
    @ExcelProperty({"信息表", "消息内容"})
    private String content;
    @ExcelProperty({"信息表", "发送人id"})
    private Integer senderId;
    @ExcelProperty({"信息表", "发送人名字"})
    private String senderName;
    @ExcelProperty({"信息表", "接收人名字"})
    private String receiverName;
    @ExcelProperty({"信息表", "接收 人id"})
    private String receiverId;

    @ExcelProperty({"学生信息", "状态"})
    private Integer isRead;
    @ExcelProperty({"学生信息", "状态"})
    private String status;

    public String getStatus() {
        String status = "";
        if (isRead == 1) {
            return status = "已读";
        } else {
            return status = "未读";
        }

    }
}
