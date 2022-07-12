package com.ztc.mapper;

import com.ztc.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztc.entity.Message_export;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【message】的数据库操作Mapper
 * @createDate 2022-05-02 18:33:55
 * @Entity com.ztc.entity.Message
 */
public interface MessageMapper extends BaseMapper<Message> {
    public List<Message> findall(Message message);

    public int count(Message message);

    public List<Message_export> exportmessage(Message message);
}




