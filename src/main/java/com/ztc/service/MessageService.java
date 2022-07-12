package com.ztc.service;

import com.ztc.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ztc.entity.Message_export;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【message】的数据库操作Service
 * @createDate 2022-05-02 18:33:55
 */
public interface MessageService extends IService<Message> {
    public List<Message> findall(Message message);

    public int count(Message message);

    public List<Message_export> exportmessage(Message message);
}
