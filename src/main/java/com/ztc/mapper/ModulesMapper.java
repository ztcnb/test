package com.ztc.mapper;

import com.ztc.entity.MenuInfo;
import com.ztc.entity.Modules;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【modules】的数据库操作Mapper
 * @createDate 2022-04-20 08:28:12
 * @Entity com.ztc.entity.Modules
 */
public interface ModulesMapper extends BaseMapper<Modules> {
    public List<Modules> findAll();

    public List<Modules> findOneLevel();

    public int findIsHvaeSon(int id);

    public int findIsHavemodules(int id);


    public List<Modules> notinId(Modules modules);

    public int findmodulesId(int id);

    public List<MenuInfo> initMenu(@Param("usersId") int usersId, @Param("type") String type);
}




