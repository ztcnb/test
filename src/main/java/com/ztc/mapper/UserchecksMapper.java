package com.ztc.mapper;

import com.ztc.entity.Userchecks;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 22838
 * @description 针对表【userchecks】的数据库操作Mapper
 * @createDate 2022-04-30 12:02:39
 * @Entity com.ztc.entity.Userchecks
 */
public interface UserchecksMapper extends BaseMapper<Userchecks> {

    public Userchecks getTodaySignIn(@Param("userId") Integer userId);

}




