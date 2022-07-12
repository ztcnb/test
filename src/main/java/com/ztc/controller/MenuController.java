package com.ztc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ztc.entity.MenuInfo;
import com.ztc.entity.Modules;
import com.ztc.entity.Rolemodules;
import com.ztc.service.ModulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private ModulesService modulesService;

    @GetMapping("/init")
    public Map<String,Object> getMenu(Integer usersId){

        //1获取当前登录用户的能操作的所有菜单
      List<MenuInfo> initList = modulesService.initMenu(usersId,"m");

        List<MenuInfo> rootMenu=new ArrayList<>();
        for(MenuInfo m : initList){
            if(m.getParentId()==-1){
                rootMenu.add(m);
            }
        }

        for(MenuInfo m: rootMenu){
            m.setChild(getChildren(m.getId(),initList));
        }

        //组装结果
        Map<String,Object> homeInfoMap=new HashMap<>();
        homeInfoMap.put("title","首页");
        homeInfoMap.put("href","xx");
        Map<String,Object> logoInfoMap=new HashMap<>();
        logoInfoMap.put("title","CRM");
        logoInfoMap.put("image","images/logo.png");
        logoInfoMap.put("href","");
        Map<String,Object> menuInfoMap=new HashMap<>();
        menuInfoMap.put("title","常规管理");
        menuInfoMap.put("icon","fa fa-address-book");
        menuInfoMap.put("href","");
        menuInfoMap.put("target","_self");
        menuInfoMap.put("child",rootMenu);

        List<Map<String,Object>> mlist=new ArrayList<>();
        mlist.add(menuInfoMap);

        //最终格式
        Map<String,Object> rslMap=new HashMap<>();
        rslMap.put("homeInfo",homeInfoMap);
        rslMap.put("logoInfo",logoInfoMap);
        rslMap.put("menuInfo",mlist);

        return  rslMap;
    }

    private List<MenuInfo> getChildren(Integer pid,List<MenuInfo>all){

        List<MenuInfo> children=new ArrayList<>();
        //1在所有菜单里找父id=pid
        for (MenuInfo m:all){
            if (m.getParentId()==pid){
                children.add(m);
            }
        }
        //2递归找子的子的子。。。
        for (MenuInfo m:children){
            m.setChild(getChildren(m.getId(),all));


        }
        //3递归退出
        if (children.size()==-1){
            return new ArrayList<>();
        }
        return children;

    }
}
