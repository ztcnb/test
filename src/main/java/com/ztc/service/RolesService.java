package com.ztc.service;

import com.ztc.entity.Roles;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ztc.entity.Userroles;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【roles】的数据库操作Service
 * @createDate 2022-04-19 11:03:54
 */
public interface RolesService extends IService<Roles> {
    public List<Roles> notinId(Roles roles);

    public boolean isZXS(Integer roleId);
}
