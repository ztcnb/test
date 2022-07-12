package com.ztc.mapper;

import com.ztc.entity.Modules;
import com.ztc.entity.Userroles;
import com.ztc.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【users】的数据库操作Mapper
 * @createDate 2022-04-18 17:41:11
 * @Entity com.ztc.entity.Users
 */
public interface UsersMapper extends BaseMapper<Users> {

    public List<Users> findAll(Users users);

    public int countAll(Users users);

    /**
     * 修改是否锁定
     */
    public int updateIsLockoutInt(@Param("id") int id, @Param("isLockout") int isLockout);

    /**
     * 重置密码
     */
    public int resetPassword(@Param("id") int id, @Param("password") String password);

    public List<Modules> getPermission(@Param("loginName") String loginName, @Param("password") String password);

}




