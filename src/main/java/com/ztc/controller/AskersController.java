package com.ztc.controller;

import com.ztc.entity.Askers;
import com.ztc.entity.Users;
import com.ztc.service.AskersService;
import com.ztc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("askers")
@CrossOrigin
public class AskersController {

    @Autowired
    private AskersService askersService;

    //全查
    @GetMapping("/findAll")
    //创建分页组件(第一个参数，当前第几页，第二个参数，每页几条)
    public Map<String,Object> findAll(Askers askers) {
        List<Askers> list = askersService.find(askers);
        int count = askersService.count(askers);
        Map<String,Object> rslmap=new HashMap<>();
        rslmap.put("code","0");
        rslmap.put("msg","成功");
        rslmap.put("data",list);
        rslmap.put("count",count);
        return  rslmap;
    }


}
