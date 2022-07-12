package com.ztc.controller;

import com.ztc.entity.*;
import com.ztc.service.NetfollowsService;
import com.ztc.service.UserrolesService;
import com.ztc.service.UsersService;
import com.ztc.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/netfollows")
@CrossOrigin
public class NetfollowsController {

    @Autowired
    private NetfollowsService netfollowsService;
    @Autowired
    private UserrolesService userrolesService;


    @GetMapping("/findAll")
    public Map<String,Object> findALL(Netfollows netfollows){

        List<Userroles> byId = userrolesService.findById(netfollows.getUserId());
        for(Userroles u : byId){
            if (u.getName().equals("咨询经理")){
                netfollows.setUserId(null);
                break;
            }else{
                netfollows.setUserId(netfollows.getUserId());
            }
        }

        List<Netfollows> list = netfollowsService.findAll(netfollows);
        int count=netfollowsService.count(netfollows);
        Map<String,Object> rslmap=new HashMap<>();
        rslmap.put("code","0");
        rslmap.put("msg","成功");
        rslmap.put("data",list);
        rslmap.put("count",count);
        return  rslmap;
    }
   //delete
    @PostMapping("/{id}")
    public Map<String,Object> del(@PathVariable("id") Integer id){
        boolean rs1= netfollowsService.removeById(id);
        Map<String,Object> map=new HashMap<>();
        if (rs1){
            map.put("code","0");
            map.put("msg","删除成功");
        }else {
            map.put("code","1");
            map.put("msg","删除失败");
        }
        return map;
    }
    //update
    @PostMapping("/updateroles")
    public Map<String,Object> updateroles(Netfollows netfollows){
        Map<String,Object> map=new HashMap<>();
        List<Netfollows> list =netfollowsService.notinId(netfollows);
        for (int i=0;i<list.size();i++){
            if (netfollows.getStudnetName().equals(list.get(i).getStudnetName())){
                map.put("code","1");
                map.put("msg","角色名字重复");
                return map;
            }
        }
        boolean rs1= netfollowsService.updateById(netfollows);
        if (rs1){
            map.put("code","0");
            map.put("msg","修改成功");
        }else {
            map.put("code","1");
            map.put("msg","修改失败");
        }
        return map;
    }

    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response, Netfollows netfollows){
        //1，查询数据
        List<Netfollows_export> list= netfollowsService.expornetfollows(netfollows);
        //2，导出到excel
        ExcelUtil.export(response,"students","students",list, Netfollows_export.class);
    }
}
