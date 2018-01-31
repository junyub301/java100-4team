package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.Item;
import java100.app.domain.Photo;

public interface ItemService {
    int add(Item item, List<Photo> photoList);

    List<Item> list(int pageNo, int pageSize, Map<String, Object> options);
    
    Item getItem(int no);

    int getTotalCount();
}





