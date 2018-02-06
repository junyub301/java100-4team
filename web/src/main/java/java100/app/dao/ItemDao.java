package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Item;

public interface ItemDao {
    int insert(Item item);
    List<Item> findrentAll(Map<String,Object> params);
    List<Item> findlendAll(Map<String,Object> params);
    Item findByNo(int no);
    int countAll();
}


















