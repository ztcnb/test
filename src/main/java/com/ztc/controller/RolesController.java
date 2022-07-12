package com.ztc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztc.entity.Roles;
import com.ztc.entity.Userroles;
import com.ztc.service.RolesService;
import com.ztc.service.UserrolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;
    @Autowired
    private UserrolesService userrolesService;


    @GetMapping("/findall")
    //创建分页组件(第一个参数，当前第几页，第二个参数，每页几条)
    public Map<String,Object> findByPage(Integer page, Integer limit, Map<String,Object>map) {

        //创建查询条件构造器
        QueryWrapper<Roles> wrapper = new QueryWrapper<>();
        List<Roles> list = rolesService.list();
        Page<Map<String,Object>> pages=new Page<>(page,limit);
        IPage<Map<String, Object>> rsl= rolesService.pageMaps(pages,wrapper);
        Map<String,Object> rslmap=new HashMap<>();
        rslmap.put("code","0");
        rslmap.put("msg","成功");
        rslmap.put("data",rsl.getRecords());
        rslmap.put("count",rsl.getTotal());
        return  rslmap;
    }
    //新增
    @PostMapping("/addroles")
    public Map<String,Object> add(@ModelAttribute Roles roles){

        Map<String,Object> map=new HashMap<>();
        List<Roles> list =rolesService.list();
        for (int i=0;i<list.size();i++){
            if (roles.getName().equals(list.get(i).getName())){
                map.put("code","1");
                map.put("msg","角色名字重复");
                return map;
            }
        }
        boolean rs1= rolesService.save(roles);
        if (rs1){
            map.put("code","0");
            map.put("msg","修改成功");
        }else {
            map.put("code","1");
            map.put("msg","修改失败");
        }
           return map;
    }

    //update
    @PostMapping("/updateroles")
    public Map<String,Object> updateroles(Roles roles){
        Map<String,Object> map=new HashMap<>();
        List<Roles> list =rolesService.notinId(roles);
        for (int i=0;i<list.size();i++){
            if (roles.getName().equals(list.get(i).getName())){
                map.put("code","1");
                map.put("msg","角色名字重复");
                return map;
            }
        }
        boolean rs1= rolesService.updateById(roles);
        if (rs1){
            map.put("code","0");
            map.put("msg","修改成功");
        }else {
            map.put("code","1");
            map.put("msg","修改失败");
        }
        return map;
    }

    //delete
    @PostMapping("/{id}")
    public Map<String,Object> del(@PathVariable Integer id,Userroles userroles){

        Map<String,Object> map=new HashMap<>();
        int num =userrolesService.findUsersId(userroles);
            if (num>0){
                map.put("code","1");
                map.put("msg","角色被分配");
                return map;
            }

        boolean rs1=rolesService.removeById(id);

        if (rs1){
            map.put("code","0");
            map.put("msg","删除成功");
        }else {
            map.put("code","1");
            map.put("msg","删除失败");
        }
        return map;
    }


}
