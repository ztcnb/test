package com.ztc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.ztc.anno.NoToken;
import com.ztc.entity.Users;
import com.ztc.service.UsersService;
import com.ztc.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wsy
 * @create 2022-04-01 15:27
 */

@RestController
@RequestMapping("user")
@CrossOrigin
public class LoginController {
    @Autowired
    private UsersService usersService;

    @PostMapping("login")
    @NoToken//不拦截登陆
    public Map<String, Object> login(Users users) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("loginName", users.getLoginName()).
                eq("password", users.getPassword());
        Users u = usersService.getOne(wrapper);

        Map<String, Object> rslmap = new HashMap<>();
        if (u != null) {
            String token ="";
            //生成token
            try {
             token = TokenUtil.sign(u,60*30*1000);
            } catch (UnsupportedEncodingException |JsonProcessingException e) {
                e.printStackTrace();
            }
            //登陆成功
            rslmap.put("code", "0");
            rslmap.put("token", token);//返回token给页面
        }else {
            //登陆失败
            rslmap.put("code", "1");
        }
        return rslmap;
    }




}
