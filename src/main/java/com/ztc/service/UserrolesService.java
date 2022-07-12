package com.ztc.service;

import com.ztc.entity.Roles;
import com.ztc.entity.Userroles;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【userroles】的数据库操作Service
 * @createDate 2022-04-20 08:27:51
 */
public interface UserrolesService extends IService<Userroles> {
    public int findUsersId(Userroles userroles);

    public List<Userroles> findById(Integer usersId);
}
