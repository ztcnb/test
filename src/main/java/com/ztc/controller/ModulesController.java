package com.ztc.controller;


import com.ztc.entity.Modules;
import com.ztc.service.ModulesService;
import com.ztc.util.LayUiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/modules")
public class ModulesController {

    @Autowired
    private ModulesService modulesService;

    @GetMapping("/findAll")
    public Map<String, Object> findAll(Modules modules) {
        // 调用service
        List<Modules> list = modulesService.findAll();
        // 返回结果都是以Map的方式返会给Layui所以返回值都是Map
        return LayUiResult.toClient("0", "success",0,list);
    }
    @GetMapping("/findOneLevel")
    public List<Modules> findOneLevel(){
        return modulesService.findOneLevel();
    }
    @GetMapping("/findIsHvaeSon")
    public boolean findIsHvaeSon(int id) {
        return modulesService.findIsHvaeSon(id) >0 ? true : false;
    }
    @GetMapping("/findIsHaveProduct")
    public boolean findIsHaveProduct(int id) {
        return modulesService.findIsHavemodules(id) >0 ? true : false;
    }


}
