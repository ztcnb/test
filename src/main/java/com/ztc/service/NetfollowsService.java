package com.ztc.service;

import com.ztc.entity.Netfollows;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ztc.entity.Netfollows_export;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【netfollows】的数据库操作Service
 * @createDate 2022-04-30 12:02:21
 */
public interface NetfollowsService extends IService<Netfollows> {
    public List<Netfollows> findAll(Netfollows netfollows);

    public int count(Netfollows netfollows);

    public List<Netfollows> findAlljl(Netfollows netfollows);

    public int countjl(Netfollows netfollows);

    public List<Netfollows_export> expornetfollows(Netfollows netfollows);

    public List<Netfollows> notinId(Netfollows netfollows);
}
