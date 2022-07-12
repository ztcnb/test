package com.ztc.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ztc.entity.*;
import com.ztc.service.*;
import com.ztc.util.ExcelUtil;
import com.ztc.util.LayUiResult;
import com.ztc.util.ObjectConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student1")
@CrossOrigin
public class MystudentController {

    @Autowired
    private StudentsService studentsService;
    @Autowired
    private UserrolesService userrolesService;
    @Autowired
    private AskersService askersService;
    @Autowired
    private NetfollowsService netfollowsService;

    @Autowired
    private MessageService messageService;

    //全查
    @GetMapping("/findAll")
    //创建分页组件(第一个参数，当前第几页，第二个参数，每页几条)
    public Map<String,Object> findAll(Students students) {
        List<Userroles> byId = userrolesService.findById(students.getUsersId());
        for(Userroles u : byId){
            if (u.getName().equals("咨询经理")){
                students.setNetpusherid(null);
                break;
            }else{
                students.setNetpusherid(students.getUsersId());
            }
        }

        List<Students> list = studentsService.findAll(students);
        int count = studentsService.count(students);
        Map<String,Object> rslmap=new HashMap<>();
        rslmap.put("code","0");
        rslmap.put("msg","成功");
        rslmap.put("data",list);
        rslmap.put("count",count);
        return  rslmap;
    }


    //添加跟踪信息
    @PostMapping("/addxx")
    public Map<String,Object> addxx(Netfollows netfollows){

        Map<String,Object> map=new HashMap<>();
        boolean rs1= netfollowsService.save(netfollows);
        if (rs1){
            map.put("code","0");
            map.put("msg","添加成功");
        }else {
            map.put("code","1");
            map.put("msg","添加失败");
        }
        return map;
    }

    //添加跟踪信息
    @PostMapping("/addfxx")
    public Map<String,Object> addfxx(Message message){

        Map<String,Object> map=new HashMap<>();
        boolean rs1= messageService.save(message);
        if (rs1){
            map.put("code","0");
            map.put("msg","添加成功");
        }else {
            map.put("code","1");
            map.put("msg","添加失败");
        }
        return map;
    }

    //delete
    @PostMapping("/del")
    public Map<String,Object> del(int id){
        int rsl = studentsService.upddelete(id);
        Map<String,Object> map=new HashMap<>();
        if (rsl>0){
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
    public Map<String,Object> updateroles(Students students){
        Map<String,Object> map=new HashMap<>();
        List<Students> list =studentsService.notinId(students);
        for (int i=0;i<list.size();i++){
            if (students.getName().equals(list.get(i).getName())){
                map.put("code","1");
                map.put("msg","角色名字重复");
                return map;
            }
        }
        boolean rs1= studentsService.updateById(students);
        if (rs1){
            map.put("code","0");
            map.put("msg","修改成功");
        }else {
            map.put("code","1");
            map.put("msg","修改失败");
        }
        return map;
    }

    //新增
    @PostMapping("/add")
    public Map<String,Object> add(@ModelAttribute Students students){

        Map<String,Object> map=new HashMap<>();
        List<Students> list =studentsService.list();
        for (int i=0;i<list.size();i++){
            if (students.getName().equals(list.get(i).getName())){
                map.put("code","1");
                map.put("msg","角色名字重复");
                return map;
            }
        }
        boolean rs1= studentsService.save(students);
        if (rs1){
            map.put("code","0");
            map.put("msg","添加成功");
        }else {
            map.put("code","1");
            map.put("msg","添加失败");
        }
        return map;
    }

    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response,Students students){
        //1，查询数据
        List<Student_export> list= studentsService.exportstudents(students);
        //2，导出到excel
        ExcelUtil.export(response,"students","students",list, Student_export.class);
    }



}
