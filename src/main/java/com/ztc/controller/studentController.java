package com.ztc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
@RequestMapping("/student")
@CrossOrigin
public class studentController {

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

//    @GetMapping("/findAll")
//    public Map<String,Object> find(Students students,Integer usersId,Integer page,Integer limit){
//        //1 获取当前登录用户的角色
//        boolean isZXY =false;
//        boolean isZXJL =false;
//        boolean isAll =false;
//        List<Roles> rolesList= studentsService.getRolesByUserId(usersId);
//        for (Roles r : rolesList){
//            if ("咨询经理".equals(r.getName())){
//                isZXJL = true;
//            }
//            if ("咨询员".equals(r.getName())){
//                isZXY = true;
//            }
//        }
//        if (isZXJL && isZXY){
//            isAll = true;
//        }
//
//        QueryWrapper<Students> q1 = new QueryWrapper<>();
//        q1.eq("isValid","1");
//
//        if (isZXY == true && isAll == false){
//            q1.eq("netpusherid",usersId).eq("isValid","1");
//        }
//
//
//        q1.like(StringUtils.isBlank(students.getName())? false : true,
//                "name",students.getName())
//        .ge(StringUtils.isBlank(students.getBeginTime())? false : true,
//                "createTime",students.getCreateTime())
//        .le(StringUtils.isBlank(students.getEndTime())? false : true,
//                "createTime",students.getEndTime())
//        .eq(StringUtils.isBlank(students.getStuStatus())? false : true,
//                "stuStatus",students.getStuStatus());
//
//        IPage<Map<String,Object>> rsl = studentsService.pageMaps(new Page<>(page,limit),q1);
//        return LayUiResult.toClient("0", "success", (int) rsl.getTotal(), rsl.getRecords());
//
//
//    }

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

    //发信息
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

    @PostMapping("/import")
    //创建分页组件(第一个参数，当前第几页，第二个参数，每页几条)
    public Map<String,Object> importExcel(MultipartFile file) {

        //接受文件冰解析数据
        List<Stuent_import> importList = ExcelUtil.importExcel(file,Stuent_import.class, null);
        importList.forEach(s -> {
            s.setIsPay(s.getStringIsPay().equals("已付款") ? 1 : 0);
            if (s.getStatus().equals("已录入,未分配")){
                s.setStuStatus(0);
            }else if (s.getStatus().equals("已分配咨询师")){
                s.setStuStatus(1);
            }else if (s.getStatus().equals("正在跟踪")){
                s.setStuStatus(2);
            }else if (s.getStatus().equals("跟踪结束")){
                s.setStuStatus(3);
            }else {
                s.setStuStatus(4);
            }
        });

        //2.3批量保存
//        importlist.forEach(System.out::println);//相当于一个for循环
        List<Students> memberList=ObjectConversion.copy(importList,Students.class);

        Boolean rsl=studentsService.saveBatch(memberList);

        //返回信息
        Map<String,Object> rslmap=new HashMap<>();
        rslmap.put("code",rsl ? "0":"1");
        rslmap.put("msg",rsl ? "导入成功":"导入失败");
        return  rslmap;
    }



    @PostMapping ("/batchFenZXS")
    public Map<String,Object> batchFenZXS(@RequestParam("studentIs") List<Integer> studentIs,String askerId,String askerName){
        UpdateWrapper<Students> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("stuStatus","1").set("askerId",askerId).set("zixunName",askerName)
                .in("id",studentIs);
        return studentsService.update(updateWrapper) ? LayUiResult.toClient("0","分配成功"):
                LayUiResult.toClient("0","分配失败");
    }

}
