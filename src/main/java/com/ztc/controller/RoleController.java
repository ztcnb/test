package com.ztc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ztc.entity.Askers;
import com.ztc.entity.Roles;
import com.ztc.entity.Userroles;
import com.ztc.entity.Users;
import com.ztc.service.AskersService;
import com.ztc.service.RolesService;
import com.ztc.service.UserrolesService;
import com.ztc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RolesService rolesService;
    @Autowired
    private UserrolesService userrolesService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private AskersService askersService;



    /*
     * 查询所有的角色
     * */
    @GetMapping("/findAll")
    public List<Roles> findAll(){
        return rolesService.list();
    }

    /*
    * 查询某个用户的角色
    * */
    @GetMapping("/findByUid")
    public List<Userroles> findByUid(Integer uid){
        QueryWrapper<Userroles> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("usersId",uid);
        return userrolesService.list(queryWrapper);
    }

    @PostMapping("/addUserRoles")
    public  boolean addUserRoles(Userroles userroles){
        //同步咨询师的数据
        if(rolesService.isZXS(userroles.getRoleId())){
           Users u =usersService.getById(userroles.getUsersId());
            Askers a =new Askers();
            a.setAskerId(u.getId());
            a.setAskerName(u.getLoginName());
            askersService.save(a);

        }

        return userrolesService.save(userroles);
    }

    @PostMapping("/deleteUserRoles")
    public  boolean deleteUserRoles(Userroles userroles){
        //同步咨询师的数据
        if(rolesService.isZXS(userroles.getRoleId())){
            askersService.removeById(userroles.getUsersId());

        }

        QueryWrapper<Userroles> queryWrapper=new QueryWrapper<>();
       queryWrapper.eq("usersId",userroles.getUsersId()).
                    eq("roleId",userroles.getRoleId());
        return userrolesService.remove(queryWrapper);
    }


}
