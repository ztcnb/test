package com.ztc.service;

import com.ztc.entity.Askers;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【askers】的数据库操作Service
 * @createDate 2022-04-30 12:02:09
 */
public interface AskersService extends IService<Askers> {
    public List<Askers> find(Askers askers);

    public int count(Askers askers);
}
