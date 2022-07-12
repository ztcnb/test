package com.ztc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.entity.Askers;
import com.ztc.service.AskersService;
import com.ztc.mapper.AskersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【askers】的数据库操作Service实现
 * @createDate 2022-04-30 12:02:09
 */
@Service
public class AskersServiceImpl extends ServiceImpl<AskersMapper, Askers>
        implements AskersService {

    @Autowired
    private AskersMapper askersMapper;

    @Override
    public List<Askers> find(Askers askers) {
        return askersMapper.find(askers);
    }

    @Override
    public int count(Askers askers) {
        return askersMapper.count(askers);
    }
}




