package java100.app.dao;

import java.util.List;

import java100.app.domain.RequestItem;

public interface RequestItemDao {
    List<RequestItem> list();
    int insert(RequestItem requestItem);
    RequestItem findByNo(int no);
    int update(RequestItem requestItem);
    int delete(int no);
}















