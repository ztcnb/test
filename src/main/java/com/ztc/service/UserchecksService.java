package com.ztc.service;

import com.ztc.entity.Userchecks;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * @author 22838
 * @description 针对表【userchecks】的数据库操作Service
 * @createDate 2022-04-30 12:02:39
 */
public interface UserchecksService extends IService<Userchecks> {
    public Userchecks getTodaySignIn(Integer userId);
}
