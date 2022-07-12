package com.ztc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.entity.Modules;
import com.ztc.entity.Userroles;
import com.ztc.entity.Users;
import com.ztc.service.UsersService;
import com.ztc.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【users】的数据库操作Service实现
 * @createDate 2022-04-18 17:41:11
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
        implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> findAll(Users users) {
        return usersMapper.findAll(users);
    }

    @Override
    public int countAll(Users users) {
        return usersMapper.countAll(users);
    }

    @Override
    public int updateIsLockoutInt(int id, int isLockout) {
        return usersMapper.updateIsLockoutInt(id, isLockout);
    }

    @Override
    public int resetPasswordint(int id, String password) {
        return usersMapper.resetPassword(id, password);
    }

    @Override
    public List<Modules> getPermission(String loginName, String password) {
        return usersMapper.getPermission(loginName, password);
    }

}




