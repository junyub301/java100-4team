package java100.app.service;

import java.util.List;

import java100.app.domain.Message;

public interface MessageService {
    List<Message> list(int no);
    int add(Message message);
    Message get(int no);
    int update(Message message);
    int delete(int no);
}





