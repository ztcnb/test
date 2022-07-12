package com.ztc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.entity.Message;
import com.ztc.entity.Message_export;
import com.ztc.service.MessageService;
import com.ztc.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【message】的数据库操作Service实现
 * @createDate 2022-05-02 18:33:55
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
        implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> findall(Message message) {
        return messageMapper.findall(message);
    }

    @Override
    public int count(Message message) {
        return messageMapper.count(message);
    }

    @Override
    public List<Message_export> exportmessage(Message message) {
        return messageMapper.exportmessage(message);
    }
}




