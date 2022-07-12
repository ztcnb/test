package com.ztc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.entity.Roles;
import com.ztc.entity.Userroles;
import com.ztc.service.UserrolesService;
import com.ztc.mapper.UserrolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【userroles】的数据库操作Service实现
 * @createDate 2022-04-20 08:27:51
 */
@Service
public class UserrolesServiceImpl extends ServiceImpl<UserrolesMapper, Userroles>
        implements UserrolesService {
    @Autowired
    private UserrolesMapper userrolesMapper;

    @Override
    public int findUsersId(Userroles userroles) {
        return userrolesMapper.findUsersId(userroles);
    }

    @Override
    public List<Userroles> findById(Integer usersId) {
        return userrolesMapper.findById(usersId);
    }


}




