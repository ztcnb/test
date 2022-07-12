package com.ztc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztc.entity.Modules;
import com.ztc.entity.Rolemodules;
import com.ztc.entity.Roles;
import com.ztc.entity.Userroles;
import com.ztc.service.ModulesService;
import com.ztc.service.RolemodulesService;
import com.ztc.util.LayUiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/modules")
public class ModulesController2 {
    @Autowired
    private ModulesService modulesService;
    @Autowired
    private RolemodulesService rolemodulesService;

    @GetMapping("/FindAll")
    public List<Modules> FindAll(){
        return modulesService.list();
    }

    @GetMapping("/getMenu")
    public List<Modules> getMenu(Integer roleId){
        QueryWrapper<Rolemodules> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("roleId",roleId);
        List<Rolemodules> currList=rolemodulesService.list(queryWrapper);

        List<Modules> allMenu=modulesService.list();
        List<Modules> rootMenu=new ArrayList<>();
        for(Modules m : allMenu){
            if(m.getParentId()==-1){
                rootMenu.add(m);
            }
        }

        for(Modules m: rootMenu){
           m.setChildren(getChildren(m.getId(),allMenu,currList));
         for(Rolemodules rm:currList){
             if (m.getId()==rm.getModuleId()){
                 m.setChecked(true);//勾选已有的菜单选项
                 m.setSpread(true);
             }
         }
        }
        return  rootMenu;
    }

       private List<Modules> getChildren(Integer pid,List<Modules>all,List<Rolemodules>currList){

        List<Modules> children=new ArrayList<>();
        //1在所有菜单里找父id=pid
           for (Modules m:all){
               if (m.getParentId()==pid){
                   children.add(m);
               }
           }
        //2递归找子的子的子。。。
           for (Modules m:children){
               m.setChildren(getChildren(m.getId(),all,currList));

               for(Rolemodules rm:currList){
                   if (m.getId()==rm.getModuleId()){
                       m.setChecked(true);//勾选已有的菜单选项
                       m.setSpread(true);
                   }
               }
           }
        //3递归退出
        if (children.size()==-1){
            return new ArrayList<>();
        }
        return children;

       }

       @PostMapping("/savePermission")
       public Boolean savePermission(Integer roleId,@RequestParam("selectedModuleIds") List<Integer>selectedModuleIds){
           //1,删除当前角色的所有权限 delete form rolemodules where roleId=#{id}

           QueryWrapper<Rolemodules> queryWrapper= new QueryWrapper<>();
           queryWrapper.eq("roleId",roleId);
           rolemodulesService.remove(queryWrapper);
           //2，批量保存勾选权限 insert into rolemodules()values()
          List<Rolemodules> bathsvaeList=new ArrayList<>();
          for (Integer mid:selectedModuleIds){
              Rolemodules r=new Rolemodules();
              r.setRoleId(roleId);
              r.setModuleId(mid);
              bathsvaeList.add(r);
          }
          return rolemodulesService.saveBatch(bathsvaeList);
       }
       //二级菜单
    @GetMapping("/find")
    public Map<String, Object> findAll(){

        return LayUiResult.toClient("0","cuccess", (int) modulesService.count(),modulesService.list());
    }


    //新增
//    @PostMapping("/add")
//    public Map<String,Object> add(@ModelAttribute Modules modules){
//        Map<String,Object> map=new HashMap<>();
//        List<Modules> list =modulesService.list();
//        for (int i=0;i<list.size();i++){
//            if (modules.getName().equals(list.get(i).getName())){
//                map.put("code","1");
//                map.put("msg","节点名字重复");
//                return map;
//            }
//        }
//        boolean rs1= modulesService.save(modules);
//        if (rs1){
//            map.put("code","0");
//            map.put("msg","添加成功");
//        }else {
//            map.put("code","1");
//            map.put("msg","添加失败");
//        }
//        return map;
//    }


    //update
    @PostMapping("/updateModules")
    public Map<String,Object> updateroles(Modules modules){
        Map<String,Object> map=new HashMap<>();
        List<Modules> list =modulesService.notinId(modules);
        for (int i=0;i<list.size();i++){
            if (modules.getName().equals(list.get(i).getName())){
                map.put("code","1");
                map.put("msg","角色名字重复");
                return map;
            }
        }
        boolean rs1= modulesService.updateById(modules);
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
    public Map<String,Object> del(@PathVariable Integer id){

        Map<String,Object> map=new HashMap<>();
        int num =modulesService.findmodulesId(id);
        if (num>0){
            map.put("code","1");
            map.put("msg","角色被分配");
            return map;
        }

        boolean rs1=modulesService.removeById(id);

        if (rs1){
            map.put("code","0");
            map.put("msg","删除成功");
        }else {
            map.put("code","1");
            map.put("msg","删除失败");
        }
        return map;
    }
    @PostMapping("/add")
    public Map<String,Object> AddAndSon(Modules modules){
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",modules.getName());
        long count=modulesService.count(queryWrapper);
        if (count >0){
            return LayUiResult.toClient("1","模块名重复");
        }
        return modulesService.save(modules) ? LayUiResult.toClient("0","成功") : LayUiResult.toClient("1","失败");
    }

}
