package com.ztc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.entity.MenuInfo;
import com.ztc.entity.Modules;
import com.ztc.service.ModulesService;
import com.ztc.mapper.ModulesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【modules】的数据库操作Service实现
 * @createDate 2022-04-20 08:28:12
 */
@Service
public class ModulesServiceImpl extends ServiceImpl<ModulesMapper, Modules>
        implements ModulesService {

    @Autowired
    private ModulesMapper modulesMapper;

    @Override
    public List<Modules> findAll() {
        return modulesMapper.findAll();
    }

    @Override
    public List<Modules> findOneLevel() {
        return modulesMapper.findOneLevel();
    }

    @Override
    public int findIsHvaeSon(int id) {
        return modulesMapper.findIsHvaeSon(id);
    }

    @Override
    public int findIsHavemodules(int id) {
        return modulesMapper.findIsHavemodules(id);
    }

    @Override
    public List<Modules> notinId(Modules modules) {
        return modulesMapper.notinId(modules);
    }

    @Override
    public int findmodulesId(int id) {
        return modulesMapper.findmodulesId(id);
    }

    @Override
    public List<MenuInfo> initMenu(int usersId, String type) {
        return modulesMapper.initMenu(usersId, type);
    }


}




