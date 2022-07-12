package com.ztc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.entity.Netfollows;
import com.ztc.entity.Netfollows_export;
import com.ztc.service.NetfollowsService;
import com.ztc.mapper.NetfollowsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【netfollows】的数据库操作Service实现
 * @createDate 2022-04-30 12:02:21
 */
@Service
public class NetfollowsServiceImpl extends ServiceImpl<NetfollowsMapper, Netfollows>
        implements NetfollowsService {

    @Autowired
    private NetfollowsMapper netfollowsMapper;

    @Override
    public List<Netfollows> findAll(Netfollows netfollows) {
        return netfollowsMapper.findAll(netfollows);
    }

    @Override
    public int count(Netfollows netfollows) {
        return netfollowsMapper.count(netfollows);
    }

    @Override
    public List<Netfollows> findAlljl(Netfollows netfollows) {
        return netfollowsMapper.findAlljl(netfollows);
    }

    @Override
    public int countjl(Netfollows netfollows) {
        return netfollowsMapper.countjl(netfollows);
    }

    @Override
    public List<Netfollows_export> expornetfollows(Netfollows netfollows) {
        return netfollowsMapper.expornetfollows(netfollows);
    }

    @Override
    public List<Netfollows> notinId(Netfollows netfollows) {
        return netfollowsMapper.notinId(netfollows);
    }


}




