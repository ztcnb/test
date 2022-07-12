package com.ztc.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author shkstart
 * @create 2022-03-10 上午 11:36
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createDate", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateDate", new Date(), metaObject);
    }

}
