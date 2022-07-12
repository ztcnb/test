package com.ztc.mapper;

import com.ztc.entity.Roles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztc.entity.Userroles;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【roles】的数据库操作Mapper
 * @createDate 2022-04-19 11:03:54
 * @Entity com.ztc.entity.Roles
 */
public interface RolesMapper extends BaseMapper<Roles> {

    public List<Roles> notinId(Roles roles);


}




