package java100.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.MessageDao;
import java100.app.domain.Message;
import java100.app.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired MessageDao messageDao;
    
    @Override
    public List<Message> list() {
        return messageDao.list();
    }
    
    
    @Override
    public Message get(int no) {
        Message message = messageDao.findByNo(no);
        message.setState(true);
        messageDao.checkMessage(message);
        return message;
    }
    
    @Override
    public int add(Message message) {
        
        return messageDao.insert(message);
    }
    
    @Override
    public int update(Message message) {
        
        return messageDao.update(message);
    }

    @Override
    public int delete(int no) {

        return messageDao.delete(no);
    }


}
