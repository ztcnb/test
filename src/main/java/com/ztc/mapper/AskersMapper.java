package com.ztc.mapper;

import com.ztc.entity.Askers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【askers】的数据库操作Mapper
 * @createDate 2022-04-30 12:02:09
 * @Entity com.ztc.entity.Askers
 */
public interface AskersMapper extends BaseMapper<Askers> {

    public List<Askers> find(Askers askers);

    public int count(Askers askers);
}




