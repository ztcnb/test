package com.ztc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.entity.Roles;
import com.ztc.entity.Userroles;
import com.ztc.service.RolesService;
import com.ztc.mapper.RolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【roles】的数据库操作Service实现
 * @createDate 2022-04-19 11:03:54
 */
@Service
public class RolesServiceImpl extends ServiceImpl<RolesMapper, Roles>
        implements RolesService {

    @Autowired
    private RolesMapper rolesMapper;

    @Override
    public List<Roles> notinId(Roles roles) {
        return rolesMapper.notinId(roles);
    }

    @Override
    public boolean isZXS(Integer roleId) {
        Roles roles = baseMapper.selectById(roleId);
        return "咨询师".equals(roles.getName());
    }

}




