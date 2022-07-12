package com.ztc.mapper;

import com.ztc.entity.Roles;
import com.ztc.entity.Userroles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【userroles】的数据库操作Mapper
 * @createDate 2022-04-20 08:27:51
 * @Entity com.ztc.entity.Userroles
 */
public interface UserrolesMapper extends BaseMapper<Userroles> {
    public int findUsersId(Userroles userroles);

    public List<Userroles> findById(Integer usersId);
}




