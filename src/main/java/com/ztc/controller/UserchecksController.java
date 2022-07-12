package com.ztc.controller;

import com.alibaba.excel.util.DateUtils;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ztc.entity.Userchecks;
import com.ztc.service.UserchecksService;
import com.ztc.util.LayUiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/userchecker")
@CrossOrigin
public class UserchecksController {

    @Autowired
    private UserchecksService userchecksService;


//    public Userchecks getsigin(String userId){
//        return  userchecksService.getTodaySignIn(userId);
//
//    }

    @PostMapping("/signIn")
    public Map<String,Object> signIn(Integer userId,String userName){
        Userchecks uc = new Userchecks();
        uc.setUserId(userId);
        uc.setUserName(userName);
        uc.setCheckState("1");
        uc.setCheckInTime(new Date());
        return  userchecksService.save(uc) ? LayUiResult.toClient("0","签到成功"):LayUiResult.toClient("1","签到失败");

    }

    /**
     * 获取当前用户当天的签到情况
     * @param userId
     * @return
     */
    @GetMapping("/getsigin")
    public Map<String,Object> getqd(Integer userId){
        Userchecks today = userchecksService.getTodaySignIn(userId);
        if (today == null){
            return LayUiResult.toClient("1","未签到");
        }if(today.getCheckState().equals("1")){
            return LayUiResult.toClient("2","已签到,未签退");
        }if(today.getCheckState().equals("2")){
            return LayUiResult.toClient("3","已签退");
        }
        return LayUiResult.toClient("0","数据异常");

    }

    @PostMapping("/signOut")
    public Map<String,Object> signOut(Integer userId){

        Userchecks today = userchecksService.getTodaySignIn(userId);
        Date signInDate = today.getCheckInTime();
        long nowtime = new Date().getTime();
        long sigintime10 = signInDate.getTime()+600000L;
        if (sigintime10>nowtime){
            return LayUiResult.toClient("1","签到10分钟才能签退");
        }

        UpdateWrapper<Userchecks> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("checkState","2").set("checkOutTime",new Date())
                .eq("userId",userId).gt("checkInTime", DateUtils.format(new Date(),"yyy-MM-dd"));

        return  userchecksService.update(updateWrapper) ? LayUiResult.toClient("0","签退成功"):LayUiResult.toClient("1","签退失败");

    }

}
