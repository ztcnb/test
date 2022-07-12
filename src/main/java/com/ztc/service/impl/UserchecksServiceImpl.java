package com.ztc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.entity.Userchecks;
import com.ztc.service.UserchecksService;
import com.ztc.mapper.UserchecksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 22838
 * @description 针对表【userchecks】的数据库操作Service实现
 * @createDate 2022-04-30 12:02:39
 */
@Service
public class UserchecksServiceImpl extends ServiceImpl<UserchecksMapper, Userchecks>
        implements UserchecksService {


    @Override
    public Userchecks getTodaySignIn(Integer userId) {
        return baseMapper.getTodaySignIn(userId);
    }
}




