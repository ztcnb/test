package com.ztc.controller;


import com.ztc.entity.Message;
import com.ztc.entity.Message_export;
import com.ztc.entity.Student_export;
import com.ztc.entity.Students;
import com.ztc.service.MessageService;
import com.ztc.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/message")
@CrossOrigin
public class MessageController {

    @Autowired
    private MessageService messageService;
    //全查
    @GetMapping("/findAll")
    //创建分页组件(第一个参数，当前第几页，第二个参数，每页几条)
    public Map<String,Object> findAll(Message message) {
        List<Message> list = messageService.findall(message);
        int count = messageService.count(message);
        Map<String,Object> rslmap=new HashMap<>();
        rslmap.put("code","0");
        rslmap.put("msg","成功");
        rslmap.put("data",list);
        rslmap.put("count",count);
        return  rslmap;
    }

    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response, Message message){
        //1，查询数据
        List<Message_export> list= messageService.exportmessage(message);
        //2，导出到excel
        ExcelUtil.export(response,"students","students",list, Message_export.class);
    }


}
