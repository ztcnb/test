package com.ztc.service;

import com.ztc.entity.Modules;
import com.ztc.entity.Userroles;
import com.ztc.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【users】的数据库操作Service
 * @createDate 2022-04-18 17:41:11
 */
public interface UsersService extends IService<Users> {

    public List<Users> findAll(Users users);

    public int countAll(Users users);

    /**
     * 修改是否锁定
     */
    public int updateIsLockoutInt(int id, int isLockout);

    /**
     * 重置密码
     */
    public int resetPasswordint(int id, String password);

    /*
    登录
    */
    public List<Modules> getPermission(String loginName, String password);
}
