package com.ztc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.ztc.anno.NoToken;
import com.ztc.entity.MenuInfo;
import com.ztc.entity.Modules;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService UsersService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ModulesService modulesService;

    //全查
    @GetMapping("/findAll")
    //创建分页组件(第一个参数，当前第几页，第二个参数，每页几条)
    public Map<String,Object> findAll(Users users) {
        List<Users> list = UsersService.findAll(users);
        int count = UsersService.countAll(users);
        Map<String,Object> rslmap=new HashMap<>();
        rslmap.put("code","0");
        rslmap.put("msg","成功");
        rslmap.put("data",list);
        rslmap.put("count",count);
        return  rslmap;
    }


    //新增
    @PostMapping("/add")
    public Map<String,Object> add(@ModelAttribute Users users){
        boolean sq= UsersService.save(users);
        Map<String,Object> map=new HashMap<>();
        if (sq){
            map.put("code","0");
            map.put("msg","新增成功");
        }else {
            map.put("code","1");
            map.put("msg","新增失败");
        }
        return map;
    }

    //delete
    @PostMapping("/{id}")
    public Map<String,Object> del(@PathVariable("id") Integer id){
        boolean rs1=UsersService.removeById(id);
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
    @PostMapping("/update")
    public Map<String,Object> updatehh( Users users){
        boolean rs1=UsersService.updateById(users);
        Map<String,Object> map=new HashMap<>();
        if (rs1){
            map.put("code","0");
            map.put("msg","修改成功");
        }else {
            map.put("code","1");
            map.put("msg","修改失败");
        }
        return map;
    }

    //是否锁定
    @PostMapping ("/upd")
    public Map<String, Object> updateProduct(int id ,String valid){
        int isLockout = valid.equals("on") ? 1 :0;
        //调用service
        int res = UsersService.updateIsLockoutInt(id,isLockout);
        //返回结果
        return res>0 ? LayUiResult.toClient("0", "修改成功") :
                LayUiResult.toClient("1", "修改失败");
    }


    /**
     * 重置密码
     */
    @PostMapping("/cz")
    public Map<String,Object> reset(int id,String password){
        int rs1=UsersService.resetPasswordint(id, password);
        Map<String,Object> map=new HashMap<>();
        if (rs1>0){
            map.put("code","0");
            map.put("msg","修改成功");
        }else {
            map.put("code","1");
            map.put("msg","修改失败");
        }
        return map;
    }

    //登录
    @PostMapping("/login")
    @NoToken
    public Map<String, Object> login(String loginName, String password, HttpSession session,String isLockout) {
        //判断用户是否存在，如果不存在，给提示:用户不存在
        QueryWrapper<Users> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("loginName",loginName);
        Users s = UsersService.getOne(queryWrapper1);
        if (s == null){
            return LayUiResult.toClient("1","该用户不存在!");
        }
        //判断是否锁定
        QueryWrapper<Users> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("isLockout",isLockout);
        if ("1".equals(s.getIsLockout())){
            return  LayUiResult.toClient("1","该用户已锁定，请联系管理员解锁！");
        }



        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("loginName", loginName).eq("password",password);
        Users u = UsersService.getOne(wrapper);
        if (u == null){
            //密码不对，记录错误次数
            String count = (String) redisTemplate.opsForValue().get(loginName);

            if (StringUtils.isBlank(count)){

                count = "1";

            }else {
                //如果能取到说明不是第一次
                count=(Integer.parseInt(count) +1 )+"";
            }

            redisTemplate.opsForValue().set(loginName,count);


            //当次数达到三，锁定
            if (Integer.parseInt(count) == 3 ){
                //锁定用户

                UpdateWrapper<Users> updateWrapper = new UpdateWrapper<>();
                updateWrapper.set("isLockOut",1)
                        .eq("loginName",loginName);
                UsersService.update(updateWrapper);
                //删除redis里对应的key
                redisTemplate.delete(loginName);
            }
            return LayUiResult.toClient("1","密码不对，当前错误次数"+count+",达到三次自动锁定!");
        }

        List<MenuInfo> opsList=modulesService.initMenu(u.getId(),"b");
        String opsStr="";
        for (MenuInfo m :opsList){
            opsStr +=m.getOps()+"|";
        }

        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        UpdateWrapper<Users> updateWrapper=new UpdateWrapper<>();
        updateWrapper.set("LastLonginTime",dateFormat.format(date)).eq("id",u.getId());
        UsersService.update(updateWrapper);

        //List<Modules> list = UsersService.getPermission(loginName, password);
        Map<String, Object> rslmap = new HashMap<>();
        rslmap.put("code","0");
        rslmap.put("msg","登录成功");
        rslmap.put("usersId",u.getId());//返回用户Id给页面
        rslmap.put("loginName",u.getLoginName());//返回用户名字给页面
        rslmap.put("opsPermission",opsStr);


        //生成token，并返回给页面
        String token="";
        try {
            token = TokenUtil.sign(u, 60 * 30 * 1000);
        } catch (UnsupportedEncodingException | JsonProcessingException e) {
            e.printStackTrace();
        }
        rslmap.put("token", token);
        return rslmap;
    }

    /**
     * 修改密码
     */
    @PostMapping("updatePassword")
    public Map<String,Object> updatePassword(String password,String id,String old_password,String new_password){
        Map<String,Object> map=new HashMap<>();
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        Users one = UsersService.getOne(queryWrapper);
        UpdateWrapper<Users> updateWrapper=new UpdateWrapper<>();
        updateWrapper.set("password",password)
                .eq("id",id);
        if (!old_password.equals(one.getPassword())){
            return LayUiResult.toClient("1","旧密码输入错误");
        }
        if (!new_password.equals(password)){
            return LayUiResult.toClient("1","两次新密码输入不一致");
        }
        if (!new_password.equals(password)){
            return LayUiResult.toClient("1","新密码不能和旧密码相同");
        }
        boolean rsl = UsersService.update(updateWrapper);
        if (rsl){
            map.put("code","0");
            map.put("msg","修改密码成功");
        }else {
            map.put("code","1");
            map.put("msg","修改密码失败");
        }
        return map;
    }
}

