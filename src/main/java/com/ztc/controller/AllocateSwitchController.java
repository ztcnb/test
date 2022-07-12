package com.ztc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.ztc.anno.NoToken;
import com.ztc.entity.MenuInfo;
import com.ztc.entity.Users;
import com.ztc.service.ModulesService;
import com.ztc.service.UsersService;
import com.ztc.util.LayUiResult;
import com.ztc.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class AllocateSwitchController {

    public  static  String autoAllocateSwitch = "off";


    @GetMapping("/find")
    public Map<String,Object> find(){
        Map<String,Object> map = new HashMap<>();
        map.put("isLock",autoAllocateSwitch.equals("on")? "1":"0");
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map);
        return  LayUiResult.toClient("0","成功");
    }

    @GetMapping("/set")
    public boolean set(String valid){
       autoAllocateSwitch = valid;
       return  autoAllocateSwitch.equals(valid);
    }

}

