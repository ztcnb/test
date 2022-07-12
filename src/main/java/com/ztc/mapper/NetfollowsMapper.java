package com.ztc.mapper;

import com.ztc.entity.Netfollows;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztc.entity.Netfollows_export;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【netfollows】的数据库操作Mapper
 * @createDate 2022-04-30 12:02:21
 * @Entity com.ztc.entity.Netfollows
 */
public interface NetfollowsMapper extends BaseMapper<Netfollows> {

    public List<Netfollows> findAll(Netfollows netfollows);

    public int count(Netfollows netfollows);

    public List<Netfollows> findAlljl(Netfollows netfollows);

    public int countjl(Netfollows netfollows);

    public List<Netfollows_export> expornetfollows(Netfollows netfollows);

    public List<Netfollows> notinId(Netfollows netfollows);
}




