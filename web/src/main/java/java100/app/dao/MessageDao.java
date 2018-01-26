package java100.app.dao;

import java.util.List;

import java100.app.domain.Message;

public interface MessageDao {
    List<Message> list();
    int insert(Message message);
    Message findByNo(int no);
    int update(Message message);
    int checkMessage(Message message);
    int delete(int no);
}















