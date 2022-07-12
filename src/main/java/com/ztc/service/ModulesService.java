package com.ztc.service;

import com.ztc.entity.MenuInfo;
import com.ztc.entity.Modules;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【modules】的数据库操作Service
 * @createDate 2022-04-20 08:28:12
 */
public interface ModulesService extends IService<Modules> {
    public List<Modules> findAll();

    public List<Modules> findOneLevel();

    public int findIsHvaeSon(int id);

    public int findIsHavemodules(int id);

    public List<Modules> notinId(Modules modules);

    public int findmodulesId(int id);

    public List<MenuInfo> initMenu(int usersId, String type);
}