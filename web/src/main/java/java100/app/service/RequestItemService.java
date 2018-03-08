package java100.app.service;

import java.util.List;

import java100.app.domain.RequestItem;

public interface RequestItemService {
    List<RequestItem> list(int no);
    int add(RequestItem requestItem);
    RequestItem get(int no);
    int update(RequestItem requestItem);
    int delete(int no);
}





